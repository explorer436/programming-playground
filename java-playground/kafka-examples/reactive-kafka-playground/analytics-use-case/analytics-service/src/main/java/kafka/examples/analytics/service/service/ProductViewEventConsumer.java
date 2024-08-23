package kafka.examples.analytics.service.service;

import jakarta.annotation.PostConstruct;
import kafka.examples.analytics.service.entity.ProductViewCount;
import kafka.examples.analytics.service.event.ProductViewEvent;
import kafka.examples.analytics.service.repository.ProductViewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.reactive.ReactiveKafkaConsumerTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.kafka.receiver.ReceiverRecord;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProductViewEventConsumer {

    private final ReactiveKafkaConsumerTemplate<String, ProductViewEvent> consumerTemplate;
    private final ProductViewRepository productViewRepository;

    @PostConstruct
    public void subscribe() {
        consumerTemplate
                .receive()
                // .doOnNext()
                // Do it in batches instead of doing it for each received event
                // Either or, 1000 events or 1 second, whichever happens first.
                .bufferTimeout(1000, Duration.ofSeconds(1))
                .flatMap(this::process)
                .subscribe();
    }

    private Mono<Void> process(List<ReceiverRecord<String, ProductViewEvent>> events) {
        // This will create a map with event counts based on the incoming events.
        // We have to compare the counts in the map with the values in the table and update the table accordingly.
        Map<Integer, Long> eventsMap = events.stream().map(
                        r -> r.value().getProductId()
                )
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));

        Mono<Map<Integer, ProductViewCount>> dbMapMono = productViewRepository.findAllById(eventsMap.keySet())
                .collectMap(ProductViewCount::getId)
                // what if there are no records
                .defaultIfEmpty(Collections.emptyMap());

        return dbMapMono
                .map(dbMap -> eventsMap.keySet().stream().map(
                                productId -> updateViewCount(dbMap, eventsMap, productId)
                        )
                        .collect(Collectors.toList())
                )
                // convert the Mono into Flux and save it
                .flatMapMany(productViewRepository::saveAll)
                .doOnComplete(() -> events.get(events.size() - 1).receiverOffset().acknowledge())
                .doOnError(ex -> log.error(ex.getMessage()))
                .then();
    }

    private ProductViewCount updateViewCount(Map<Integer, ProductViewCount> dbMap, Map<Integer, Long> eventMap, int productId) {
        ProductViewCount pvc = dbMap.getOrDefault(productId, new ProductViewCount(productId, 0L));
        pvc.setCount(pvc.getCount() + eventMap.get(productId));
        return pvc;
    }
}

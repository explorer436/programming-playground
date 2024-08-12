package kafka.examples.reactive.kafka.playground.withspring;

import kafka.examples.reactive.kafka.playground.withspring.model.OrderEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class MyProducerRunner implements CommandLineRunner {

    private final ReactiveKafkaProducerTemplate<String, OrderEvent> producerTemplate;

    @Override
    public void run(String... args) throws Exception {
        orderFlux()
                .flatMap(orderEvent -> this.producerTemplate.send("order-events", orderEvent.orderId().toString(), orderEvent))
                .doOnNext(r -> log.info("result: {}", r.recordMetadata()))
                .subscribe();
    }

    private Flux<OrderEvent> orderFlux(){
        return Flux
                .interval(Duration.ofMillis(500))
                .take(1000)
                .map(i -> new OrderEvent(
                        UUID.randomUUID(),
                        i,
                        LocalDateTime.now()
                ));
    }

}
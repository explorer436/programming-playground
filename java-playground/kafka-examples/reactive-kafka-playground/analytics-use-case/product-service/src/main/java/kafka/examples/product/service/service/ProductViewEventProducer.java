package kafka.examples.product.service.service;

import kafka.examples.product.service.event.ProductViewEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;
import reactor.kafka.sender.SenderRecord;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductViewEventProducer {

    // Writing this class is not enough.
    // From somewhere else in the application, we have to create an instance of this and call the subscribe() method.
    // See KafkaProducerConfig.java

    private final ReactiveKafkaProducerTemplate<String, ProductViewEvent> producerTemplate;
    private final Sinks.Many<ProductViewEvent> sink;
    private final Flux<ProductViewEvent> flux;
    private final String topic;

    public void emitEvent(ProductViewEvent event) {
        sink.tryEmitNext(event);
    }

    public void subscribe() {
        var senderRecordFlux = flux
                .map(e -> new ProducerRecord<>(topic, e.getProductId().toString(), e))
                .map(pr -> SenderRecord.create(pr, pr.key()));

        producerTemplate.send(senderRecordFlux)
                .doOnNext(result -> log.info("emitted event: {}", result.correlationMetadata()))
                .subscribe();
    }

}

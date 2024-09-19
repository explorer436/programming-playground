package kafka.examples.product.service.config;

import kafka.examples.product.service.event.ProductViewEvent;
import kafka.examples.product.service.service.ProductViewEventProducer;
import org.apache.kafka.common.network.Send;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;
import reactor.kafka.sender.SenderOptions;

@Configuration
public class KafkaProducerConfig {

    @Bean
    public SenderOptions<String, ProductViewEvent> senderOptions(KafkaProperties kafkaProperties) {
        return SenderOptions.create(kafkaProperties.buildProducerProperties());
    }

    @Bean
    public ReactiveKafkaProducerTemplate<String, ProductViewEvent> producerTemplate(SenderOptions<String, ProductViewEvent> senderOptions) {
        return new ReactiveKafkaProducerTemplate<>(senderOptions);
    }

    @Bean
    public ProductViewEventProducer productViewEventProducer(ReactiveKafkaProducerTemplate<String, ProductViewEvent> template) {
        Sinks.Many<ProductViewEvent> sink = Sinks.many().unicast().<ProductViewEvent>onBackpressureBuffer();
        Flux<ProductViewEvent> flux = sink.asFlux();

        // We can also read the name of the topc from properties file using @Value annotation.
        ProductViewEventProducer eventProducer = new ProductViewEventProducer(template, sink, flux, "product-view-events");

        eventProducer.subscribe();

        return eventProducer;
    }
}

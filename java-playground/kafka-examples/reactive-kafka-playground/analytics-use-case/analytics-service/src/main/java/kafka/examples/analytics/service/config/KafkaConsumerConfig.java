package kafka.examples.analytics.service.config;

import kafka.examples.analytics.service.event.ProductViewEvent;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.reactive.ReactiveKafkaConsumerTemplate;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import reactor.kafka.receiver.ReceiverOptions;

import java.util.List;

@Configuration
public class KafkaConsumerConfig {

    @Bean
    public ReceiverOptions<String, ProductViewEvent> receiverOptionsForProductViewEvent(KafkaProperties kafkaProperties){
        return ReceiverOptions.<String, ProductViewEvent>create(kafkaProperties.buildConsumerProperties())

                // These can go into application.yaml as well.

                .consumerProperty(JsonDeserializer.USE_TYPE_INFO_HEADERS, false)
                .consumerProperty(JsonDeserializer.VALUE_DEFAULT_TYPE, ProductViewEvent.class)
                .subscription(List.of("product-view-events"));
    }

    @Bean
    public ReactiveKafkaConsumerTemplate<String, ProductViewEvent> consumerTemplateForProductViewEvent(ReceiverOptions<String, ProductViewEvent> options){
        return new ReactiveKafkaConsumerTemplate<>(options);
    }
}
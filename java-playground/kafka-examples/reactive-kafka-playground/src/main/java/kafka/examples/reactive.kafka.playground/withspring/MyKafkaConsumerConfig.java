package kafka.examples.reactive.kafka.playground.withspring;

import kafka.examples.reactive.kafka.playground.withspring.model.DummyOrder;
import kafka.examples.reactive.kafka.playground.withspring.model.OrderEvent;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.reactive.ReactiveKafkaConsumerTemplate;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import reactor.kafka.receiver.ReceiverOptions;

import java.util.List;

@Configuration
public class MyKafkaConsumerConfig {

    @Bean
    public ReceiverOptions<String, OrderEvent> receiverOptionsForOrderEvent(KafkaProperties kafkaProperties){
        return ReceiverOptions.<String, OrderEvent>create(kafkaProperties.buildConsumerProperties())
                // We don't need to change these because... The producer and the consumer are using the same model types.

                // .consumerProperty(JsonDeserializer.REMOVE_TYPE_INFO_HEADERS, "false")
                // .consumerProperty(JsonDeserializer.USE_TYPE_INFO_HEADERS, false)
                // .consumerProperty(JsonDeserializer.VALUE_DEFAULT_TYPE, OrderEvent.class)
                .subscription(List.of("order-events"));
    }

    @Bean
    public ReactiveKafkaConsumerTemplate<String, OrderEvent> consumerTemplateForOrderEvent(ReceiverOptions<String, OrderEvent> options){
        return new ReactiveKafkaConsumerTemplate<>(options);
    }
}

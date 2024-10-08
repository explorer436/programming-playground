package kafka.examples.reactive.kafka.standalone.examples.withspring;

import kafka.examples.reactive.kafka.standalone.examples.withspring.model.DummyOrder;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.reactive.ReactiveKafkaConsumerTemplate;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import reactor.kafka.receiver.ReceiverOptions;

import java.util.List;

@Configuration
public class MyKafkaConsumerConfigAlternateModelObject {

    @Bean
    public ReceiverOptions<String, DummyOrder> receiverOptionsForDummyOrder(KafkaProperties kafkaProperties){
        return ReceiverOptions.<String, DummyOrder>create(kafkaProperties.buildConsumerProperties())

                // These can go into application.yaml as well.

                .consumerProperty(JsonDeserializer.REMOVE_TYPE_INFO_HEADERS, "false")
                .consumerProperty(JsonDeserializer.USE_TYPE_INFO_HEADERS, false)
                .consumerProperty(JsonDeserializer.VALUE_DEFAULT_TYPE, DummyOrder.class)
                .subscription(List.of("order-events"));
    }

    @Bean
    public ReactiveKafkaConsumerTemplate<String, DummyOrder> consumerTemplateForDummyOrder(ReceiverOptions<String, DummyOrder> options){
        return new ReactiveKafkaConsumerTemplate<>(options);
    }
}

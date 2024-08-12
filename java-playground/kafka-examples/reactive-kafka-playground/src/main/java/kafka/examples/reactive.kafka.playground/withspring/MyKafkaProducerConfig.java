package kafka.examples.reactive.kafka.playground.withspring;

import kafka.examples.reactive.kafka.playground.withspring.model.OrderEvent;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate;
import reactor.kafka.sender.SenderOptions;

@Configuration
public class MyKafkaProducerConfig {

    @Bean
    public SenderOptions<String, OrderEvent> senderOptions(KafkaProperties kafkaProperties){
        return SenderOptions.<String, OrderEvent>create(kafkaProperties.buildProducerProperties());
    }

    @Bean
    public ReactiveKafkaProducerTemplate<String, OrderEvent> producerTemplate(SenderOptions<String, OrderEvent> options){
        return new ReactiveKafkaProducerTemplate<>(options);
    }

}

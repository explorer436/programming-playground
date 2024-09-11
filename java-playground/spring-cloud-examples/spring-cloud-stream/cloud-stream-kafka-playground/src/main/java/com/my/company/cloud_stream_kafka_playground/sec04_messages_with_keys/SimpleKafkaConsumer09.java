package com.my.company.cloud_stream_kafka_playground.sec04_messages_with_keys;

/*
    goal: to demo a simple kafka consumer using java functional interfaces
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import reactor.core.publisher.Flux;

import java.util.function.Consumer;

@Configuration
@Slf4j
public class SimpleKafkaConsumer09 {

    @Bean
    public Consumer<Flux<Message<String>>> consumer9() {
        return flux -> flux
                .doOnNext(this::printMessageDetails)
                .subscribe();
    }

    // https://docs.spring.io/spring-kafka/reference/kafka/sending-messages.html#exchanging-messages
    // Do we have to consume "Messages"?
    // Not necessary. Depends upon the requirements.
    // If there is no need for acknowledging, just keep consuming Flux<String>

    private void printMessageDetails(Message<String> message) {
        log.info("payload: {}", message.getPayload());
        log.info("headers: {}", message.getHeaders());
    }

}

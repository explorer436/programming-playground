package com.my.company.cloud_stream_kafka_playground.sec04_messages_with_keys;

/*
    goal: to demo a simple kafka consumer using java functional interfaces
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.function.Supplier;

@Configuration
@Slf4j
public class SimpleKafkaProducer05 {

    @Bean
    public Supplier<Flux<Message<String>>> producer5() {
        return () ->
                Flux.interval(Duration.ofSeconds(1))
                                .take(5)
                        .map(this::toMessage)
                        .doOnNext(m -> log.info("produced {}", m));
    }

    // https://docs.spring.io/spring-kafka/reference/kafka/sending-messages.html#exchanging-messages
    // Do we have to produce as "Messages"?
    // No. Depends upon the requirements.
    // If there is no need for it, just keep producing Flux<String>

    private Message<String> toMessage(long l) {
        return MessageBuilder.withPayload("msg " + l)
                // .setHeader("kafka_messageKey")
                .setHeader(KafkaHeaders.KEY, "key " + l)
                .setHeader("my-dummy-key" + l, "dummy-value-" + l)
                .build();
    }

}

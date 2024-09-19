package com.my.company.cloud_stream_kafka_playground.sec04_acknowledging02;

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
public class SimpleKafkaProducer06 {

    @Bean
    public Supplier<Flux<Message<String>>> producer6() {
        return () ->
                Flux.interval(Duration.ofSeconds(1))
                                .take(5)
                        .map(this::toMessage)
                        .doOnNext(m -> log.info("produced {}", m));
    }

    private Message<String> toMessage(long l) {
        return MessageBuilder.withPayload("msg " + l)
                // .setHeader("kafka_messageKey")
                .setHeader(KafkaHeaders.KEY, "key " + l)
                .setHeader("my-dummy-key" + l, "dummy-value-" + l)
                .build();
    }

}

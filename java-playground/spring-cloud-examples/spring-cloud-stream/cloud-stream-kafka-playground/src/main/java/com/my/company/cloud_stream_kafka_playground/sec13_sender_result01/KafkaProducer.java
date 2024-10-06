package com.my.company.cloud_stream_kafka_playground.sec13_sender_result01;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.IntegrationMessageHeaderAccessor;
import org.springframework.integration.channel.FluxMessageChannel;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.function.Supplier;

/*
    goal: to demo sender results
 */

@Configuration
@Slf4j
public class KafkaProducer {

    /*
        This will be used by spring-reactive binder module.
        We also have to tell spring to send the results to this bean.
        See application-sec13_sender_result01.yaml
     */
    @Bean
    public FluxMessageChannel senderResults() {
        return new FluxMessageChannel();
    }

    @Bean
    public Supplier<Flux<Message<String>>> producer() {
        return () -> Flux.interval(Duration.ofSeconds(1))
                .take(5)
                .map(this::toMessage)
                .doOnNext(m -> log.info("produced {}", m));
    }

    private Message<String> toMessage(long i) {
        return MessageBuilder.withPayload("msg " + i)
                .setHeader(KafkaHeaders.KEY, ("key-" + i))
                // This is not a kafka header.
                // This is specific to spring cloud stream kafka binder.
                .setHeader(IntegrationMessageHeaderAccessor.CORRELATION_ID, i)
                .build();
    }

}

package com.my.company.cloud_stream_kafka_playground.sec01_simple_consumer02;

/*
    goal: to demo a simple kafka consumer using java functional interfaces
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Consumer;
import java.util.function.Function;

@Configuration
@Slf4j
public class SimpleKafkaConsumer02 {

    @Bean
    public Consumer<Flux<String>> consumer2() {
        return flux -> flux
                .doOnNext(s -> log.info("consumer received {}", s))
                .subscribe();
    }

    // Re-writing the above function without subscribe().
    // Give Mono<Void> back.
    @Bean
    public Function<Flux<String>, Mono<Void>> function2() {
        return flux -> flux
                .doOnNext(s -> log.info("function received {}", s))
                .then();
    }

}

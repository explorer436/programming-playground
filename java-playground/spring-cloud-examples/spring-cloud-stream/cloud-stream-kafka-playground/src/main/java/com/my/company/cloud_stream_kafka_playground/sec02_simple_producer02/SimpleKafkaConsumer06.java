package com.my.company.cloud_stream_kafka_playground.sec02_simple_producer02;

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
public class SimpleKafkaConsumer06 {

    @Bean
    public Consumer<Flux<String>> consumer6() {
        return flux -> flux
                .doOnNext(s -> log.info("consumer received {}", s))
                .subscribe();
    }

}

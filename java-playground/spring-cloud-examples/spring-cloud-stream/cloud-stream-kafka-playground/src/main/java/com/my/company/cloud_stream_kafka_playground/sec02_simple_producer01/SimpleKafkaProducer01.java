package com.my.company.cloud_stream_kafka_playground.sec02_simple_producer01;

/*
    goal: to demo a simple kafka consumer using java functional interfaces
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Configuration
@Slf4j
public class SimpleKafkaProducer01 {

    @Bean
    public Supplier<Flux<String>> producer1() {
        return () ->
                Flux.interval(Duration.ofSeconds(1))
                                .take(10)
                        .map(i -> "msg" + i)
                        .doOnNext(m -> log.info("produced {}", m));
    }

}

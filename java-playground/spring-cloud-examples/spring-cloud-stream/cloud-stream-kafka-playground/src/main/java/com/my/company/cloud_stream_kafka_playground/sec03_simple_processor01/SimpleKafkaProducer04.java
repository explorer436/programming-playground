package com.my.company.cloud_stream_kafka_playground.sec03_simple_processor01;

/*
    goal: to demo a simple kafka consumer using java functional interfaces
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.function.Supplier;

@Configuration
@Slf4j
public class SimpleKafkaProducer04 {

    @Bean
    public Supplier<Flux<String>> producer4() {
        return () ->
                Flux.interval(Duration.ofSeconds(1))
                                .take(10)
                        .map(i -> "msg " + i)
                        .doOnNext(m -> log.info("produced {}", m));
    }

}

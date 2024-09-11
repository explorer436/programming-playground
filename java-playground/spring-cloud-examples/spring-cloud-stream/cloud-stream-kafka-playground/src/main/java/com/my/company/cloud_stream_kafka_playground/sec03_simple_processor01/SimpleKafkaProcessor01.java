package com.my.company.cloud_stream_kafka_playground.sec03_simple_processor01;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Configuration
@Slf4j
public class SimpleKafkaProcessor01 {

    @Bean
    public Function<Flux<String>, Flux<String>> processor1() {
        return flux ->
                flux.doOnNext(m -> log.info("processor received {}", m))
                        .concatMap(this::process)
                        .doOnNext(m -> log.info("after processing {}", m));
    }

    // service layer
    private Mono<String> process(String input) {
        return Mono.just(input) // could be a DB call, service call, etc.
                .map(String::toUpperCase);
    }
}

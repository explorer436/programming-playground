package com.my.company.cloud_stream_kafka_playground.sec02_simple_producer03;

/*
    goal: to demo a simple kafka producer using java functional interfaces
 */

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.cloud.stream.binder.reactorkafka.SenderOptionsCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;
import reactor.kafka.sender.SenderOptions;

import java.time.Duration;
import java.util.function.Supplier;

@Configuration
@Slf4j
public class SimpleKafkaProducer03 {

    @Bean
    public SenderOptionsCustomizer<String, SenderOptions> customizer() {
        return (s, so) ->
                so.producerProperty(ProducerConfig.ACKS_CONFIG, "all")
                        .producerProperty(ProducerConfig.BATCH_SIZE_CONFIG, "20001");
    }

    @Bean
    public Supplier<Flux<String>> producer3() {
        return () ->
                Flux.interval(Duration.ofSeconds(1))
                                .take(10)
                        .map(i -> "msg" + i)
                        .doOnNext(m -> log.info("produced {}", m));
    }

}

package com.my.company.cloud_stream_kafka_playground.sec03_simple_processor01;

import com.my.company.cloud_stream_kafka_playground.AbstractCloudStreamKafkaPlaygroundApplicationTests;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.TestPropertySource;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.util.function.Consumer;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestPropertySource(properties = {
        "sec=sec03_simple_processor01",
        "spring.cloud.function.definition=processor1;testProducer;testConsumer",
        "spring.cloud.stream.bindings.testProducer-out-0.destination=input-topic",
        "spring.cloud.stream.bindings.processor1-in-0.destination=input-topic",
        "spring.cloud.stream.bindings.processor1-out-0.destination=output-topic",
        "spring.cloud.stream.bindings.testConsumer-in-0.destination=output-topic"
})
@Slf4j
public class SimpleKafkaProcessor01Test extends AbstractCloudStreamKafkaPlaygroundApplicationTests {

    private static final Sinks.Many<String> requestSink = Sinks.many().unicast().onBackpressureBuffer();
    private static final Sinks.Many<String> responseSink = Sinks.many().unicast().onBackpressureBuffer();

    @TestConfiguration
    static class TestConfig {

        @Bean
        public Consumer<Flux<String>> testConsumer(){
            return f -> f.doOnNext(responseSink::tryEmitNext).subscribe();
        }

        @Bean
        public Supplier<Flux<String>> testProducer() {
            return requestSink::asFlux;
        }

    }

    @Test
    public void processorTest(){

        // produce
        requestSink.tryEmitNext("sam");
        requestSink.tryEmitNext("mike");

        // consume
        responseSink.asFlux()
                .take(2)
                .timeout(Duration.ofSeconds(5))
                .doOnNext(m -> log.info("test received {}", m))
                .as(StepVerifier::create)
                .consumeNextWith(s -> assertEquals("SAM", s))
                .consumeNextWith(s -> assertEquals("MIKE", s))
                .verifyComplete();

    }
}

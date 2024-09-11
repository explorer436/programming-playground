package com.my.company.cloud_stream_kafka_playground.sec05_acknowledging;

import com.my.company.cloud_stream_kafka_playground.AbstractCloudStreamKafkaPlaygroundApplicationTests;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.test.context.TestPropertySource;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestPropertySource(properties = {
        "sec=sec05_acknowledging",
        "spring.cloud.function.definition=producer6;testConsumer",
        "spring.cloud.stream.bindings.testConsumer-in-0.destination=input-topic"
})
public class KafkaProducerWithKeyTest extends AbstractCloudStreamKafkaPlaygroundApplicationTests {

    private static final Sinks.Many<Message<String>> sink = Sinks.many().unicast().onBackpressureBuffer();

    @TestConfiguration
    static class TestConfig {

        @Bean
        public Consumer<Flux<Message<String>>> testConsumer(){
            return f -> f.doOnNext(sink::tryEmitNext).subscribe();
        }

    }

    @Test
    public void producerTest(){
        sink.asFlux()
                .map(MessageConverter::toRecord)
                .take(1)
                .timeout(Duration.ofSeconds(5))
                .as(StepVerifier::create)
                .consumeNextWith(r -> {
                    assertEquals("msg 0", r.message());
                    assertEquals("key 0", r.key());
                })

                .verifyComplete();
    }

}

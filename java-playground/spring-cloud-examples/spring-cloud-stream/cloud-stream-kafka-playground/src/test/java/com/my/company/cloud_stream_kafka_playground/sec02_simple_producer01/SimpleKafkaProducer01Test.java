package com.my.company.cloud_stream_kafka_playground.sec02_simple_producer01;

import com.my.company.cloud_stream_kafka_playground.AbstractCloudStreamKafkaPlaygroundApplicationTests;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.TestPropertySource;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestPropertySource(properties = {
        "sec=sec02_simple_producer01",
        "spring.cloud.function.definition=producer1;testConsumer",
        "spring.cloud.stream.bindings.testConsumer-in-0.destination=input-topic"
})

public class SimpleKafkaProducer01Test extends AbstractCloudStreamKafkaPlaygroundApplicationTests {

    // class variable to hold the Flux from the Producer
    private static final Sinks.Many<String> sink = Sinks.many().unicast().onBackpressureBuffer();

    // A Consumer just for this test class.
    // The class that we are testing is supposed to produce this Flux.
    // How will spring produce?
    // Using @TestPropertySource property values
    @TestConfiguration
    static class TestConfig {

        @Bean
        public Consumer<Flux<String>> testConsumer(){
            return f -> f.doOnNext(sink::tryEmitNext).subscribe();
        }

    }

    @Test
    public void producerTest(){
        sink.asFlux()
                .take(2)
                // What is the point of this?
                // It is to tell the test class to wait only for 5 seconds
                // If it doesn't receive the expected messages in the topic after 5 seconds, the test case should fail
                // What if we don't have the .timeout() setting?
                // The test case will keep waiting (forever) until messages are produced into the topic.
                .timeout(Duration.ofSeconds(5))
                .as(StepVerifier::create)
                .consumeNextWith(s -> assertEquals("msg 0", s))
                .consumeNextWith(s -> assertEquals("msg 1", s))
                .verifyComplete();
    }


}

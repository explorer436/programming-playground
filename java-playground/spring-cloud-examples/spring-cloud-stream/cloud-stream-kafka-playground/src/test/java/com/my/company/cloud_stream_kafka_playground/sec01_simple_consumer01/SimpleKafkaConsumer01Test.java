package com.my.company.cloud_stream_kafka_playground.sec01_simple_consumer01;

import com.my.company.cloud_stream_kafka_playground.AbstractCloudStreamKafkaPlaygroundApplicationTests;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.TestPropertySource;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.function.Supplier;

import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

// This is the spring-cloud way of testing - as opposed to the way in java-playground/kafka-examples/reactive-kafka-playground/analytics-use-case/analytics-service/src/test/java/kafka/examples/analytics/service/AnalyticsServiceApplicationTests.java
// This is to override the values or provide additional values than the one in application-sec01_simple_consumer01.yaml
@TestPropertySource(properties = {
        "sec=sec01_simple_consumer01",
        // testProducer is for @TestConfiguration internal class
        "spring.cloud.function.definition=consumer1;testProducer",
        "spring.cloud.stream.bindings.testProducer-out-0.destination=input-topic"
        // "logging.level.root=ERROR",
        // "com.my.company*=INFO"
})
// To test SimpleKafkaConsumer01, since we are only writing the message to the console.
@ExtendWith(OutputCaptureExtension.class)
@Slf4j
public class SimpleKafkaConsumer01Test extends AbstractCloudStreamKafkaPlaygroundApplicationTests {

    // A Supplier/Producer just for this test class.
    // The class that we are testing is supposed to receive this Flux.
    // How will spring produce?
    // Using @TestPropertySource property values
    @TestConfiguration
    static class TestConfig {

        @Bean
        public Supplier<Flux<String>> testProducer() {
            return () -> Flux.just("hello world");
        }

    }

    @Test
    public void consumerTest(CapturedOutput output) {

        // We cannot use this type of assertion.
        // Assertions.assertTrue(output.getOut().contains(dummyOrder.toString()));
        // Because there will be a delay. This is an integration test. Not a unit test.

        // This will not work either.
        // Mono.delay(Duration.ofMillis(500))
        //        .thenReturn(output.getOut()...)
        // Because, with this approach, we are not waiting.

        Mono.delay(Duration.ofMillis(1000))
                .then(Mono.fromSupplier(output::getOut))
                .as(StepVerifier::create)
                .consumeNextWith(s -> {
                    assertAll(
                            // () -> assertEquals("test", s)
                            () -> log.info(s),
                            () -> assertTrue(s.contains("consumer received hello world"))
                    );
                })
                .verifyComplete();

        // This can also be re-written this way instead of using chaining.
        /*Mono<String> mono = Mono.delay(Duration.ofMillis(500))
                .then(Mono.fromSupplier(output::getOut));
        StepVerifier.create(mono)
                .consumeNextWith(s -> assertTrue(s.contains("consumer received hello world")))
                .verifyComplete();*/
    }

}

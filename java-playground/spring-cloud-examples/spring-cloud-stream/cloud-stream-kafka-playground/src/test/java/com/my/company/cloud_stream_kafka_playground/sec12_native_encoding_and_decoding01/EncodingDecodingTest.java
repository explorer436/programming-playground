package com.my.company.cloud_stream_kafka_playground.sec12_native_encoding_and_decoding01;

import com.my.company.cloud_stream_kafka_playground.AbstractCloudStreamKafkaPlaygroundApplicationTests;
import com.my.company.cloud_stream_kafka_playground.sec12_native_encoding_and_decoding01.dto.ContactMethod;
import com.my.company.cloud_stream_kafka_playground.sec12_native_encoding_and_decoding01.dto.Email;
import com.my.company.cloud_stream_kafka_playground.sec12_native_encoding_and_decoding01.dto.Phone;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.TestPropertySource;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.util.function.Supplier;

@TestPropertySource(properties = {
        "sec=sec12_native_encoding_and_decoding01",
        "spring.cloud.function.definition=consumer;cmProducer",
        "spring.cloud.stream.bindings.cmProducer-out-0.destination=input-topic",
//        "spring.cloud.stream.bindings.cmProducer-out-0.producer.useNativeEncoding=true",
        "spring.cloud.stream.kafka.bindings.cmProducer-out-0.producer.configuration.value.serializer=org.springframework.kafka.support.serializer.JsonSerializer"
})
@ExtendWith(OutputCaptureExtension.class)
public class EncodingDecodingTest extends AbstractCloudStreamKafkaPlaygroundApplicationTests {

    @Test
    public void encodingDecodingTest(CapturedOutput output) throws InterruptedException {
        Mono.delay(Duration.ofMillis(500))
            .then(Mono.fromSupplier(output::getOut))
            .as(StepVerifier::create)
            .consumeNextWith(s -> Assertions.assertTrue(s.contains("admin@admin.com")))
            .verifyComplete();
    }

    @TestConfiguration
    static class TestConfig {

        @Bean
        public Supplier<Flux<ContactMethod>> cmProducer(){
            return () -> Flux.just(
                new Email("admin@admin.com"),
                new Phone(12345)
            );
        }

    }

}

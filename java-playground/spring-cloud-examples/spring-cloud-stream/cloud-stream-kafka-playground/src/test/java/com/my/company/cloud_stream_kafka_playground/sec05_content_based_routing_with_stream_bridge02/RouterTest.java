package com.my.company.cloud_stream_kafka_playground.sec05_content_based_routing_with_stream_bridge02;

import com.my.company.cloud_stream_kafka_playground.AbstractCloudStreamKafkaPlaygroundApplicationTests;
import com.my.company.cloud_stream_kafka_playground.sec05_content_based_routing_with_stream_bridge01.dto.DigitalDelivery;
import com.my.company.cloud_stream_kafka_playground.sec05_content_based_routing_with_stream_bridge01.dto.OrderEvent;
import com.my.company.cloud_stream_kafka_playground.sec05_content_based_routing_with_stream_bridge01.dto.OrderType;
import com.my.company.cloud_stream_kafka_playground.sec05_content_based_routing_with_stream_bridge01.dto.PhysicalDelivery;
import org.junit.jupiter.api.Assertions;
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

@TestPropertySource(properties = {
        "sec=sec05_content_based_routing_with_stream_bridge01",
        "spring.cloud.function.definition=processor01;testProducer;ddConsumer;pdConsumer",
        "spring.cloud.stream.bindings.testProducer-out-0.destination=order-events",
        "spring.cloud.stream.bindings.ddConsumer-in-0.destination=digital-topic",
        "spring.cloud.stream.bindings.pdConsumer-in-0.destination=physical-topic"
})
public class RouterTest extends AbstractCloudStreamKafkaPlaygroundApplicationTests {

    private static final Sinks.Many<OrderEvent> orderSink = Sinks.many().unicast().onBackpressureBuffer();
    private static final Sinks.Many<DigitalDelivery> ddSink = Sinks.many().unicast().onBackpressureBuffer();
    private static final Sinks.Many<PhysicalDelivery> pdSink = Sinks.many().unicast().onBackpressureBuffer();

    @Test
    public void routerTest(){

        // produce
        orderSink.tryEmitNext(new OrderEvent(1, 1, OrderType.DIGITAL));
        orderSink.tryEmitNext(new OrderEvent(2, 2, OrderType.PHYSICAL));
        orderSink.tryEmitNext(new OrderEvent(3, 3, OrderType.DIGITAL));

        // consume
        ddSink.asFlux()
                .take(Duration.ofSeconds(1))
                .as(StepVerifier::create)
                .consumeNextWith(e -> Assertions.assertEquals("1@gmail.com", e.email()))
                .consumeNextWith(e -> Assertions.assertEquals("3@gmail.com", e.email()))
                .verifyComplete();

        pdSink.asFlux()
                .take(Duration.ofSeconds(1))
                .as(StepVerifier::create)
                .consumeNextWith(e -> Assertions.assertEquals(2, e.productId()))
                .verifyComplete();

    }

    @TestConfiguration
    static class TestConfig {

        @Bean
        public Supplier<Flux<OrderEvent>> testProducer(){
            return orderSink::asFlux;
        }

        @Bean
        public Consumer<Flux<DigitalDelivery>> ddConsumer(){
            return f -> f.doOnNext(ddSink::tryEmitNext).subscribe();
        }

        @Bean
        public Consumer<Flux<PhysicalDelivery>> pdConsumer(){
            return f -> f.doOnNext(pdSink::tryEmitNext).subscribe();
        }

    }
}
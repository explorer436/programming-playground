package com.my.company.cloud_stream_kafka_playground.sec10_fan_out_with_tuples01.processor;

import com.my.company.cloud_stream_kafka_playground.common.MessageConverter;
import com.my.company.cloud_stream_kafka_playground.common.Record;
import com.my.company.cloud_stream_kafka_playground.sec05_content_based_routing_with_stream_bridge01.dto.DigitalDelivery;
import com.my.company.cloud_stream_kafka_playground.sec05_content_based_routing_with_stream_bridge01.dto.OrderEvent;
import com.my.company.cloud_stream_kafka_playground.sec05_content_based_routing_with_stream_bridge01.dto.OrderType;
import com.my.company.cloud_stream_kafka_playground.sec05_content_based_routing_with_stream_bridge01.dto.PhysicalDelivery;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuples;

import java.util.function.Function;

@Configuration
@Slf4j
public class FanoutProcessor {

    private final Sinks.Many<OrderEvent> sink = Sinks.many().multicast().onBackpressureBuffer();

    @Bean
    public Function<Flux<Message<OrderEvent>>, Tuple2<Flux<DigitalDelivery>, Flux<PhysicalDelivery>>> processor01() {
        return flux -> {

            flux
                    .map(MessageConverter::toRecord)
                    .doOnNext(r -> this.sink.tryEmitNext(r.message()))
                    .doOnNext(r -> r.acknowledgement().acknowledge())
                    .subscribe();

            return Tuples.of(
                    sink.asFlux().transform(toDigitalDelivery()),
                    sink.asFlux()
                            .filter(oe -> OrderType.PHYSICAL.equals(oe.orderType()))
                            .transform(toPhysicalDelivery())
            );

        };
    }

    private Function<Flux<OrderEvent>, Flux<DigitalDelivery>> toDigitalDelivery() {
        return flux -> flux.map(e -> new DigitalDelivery(e.productId(), "%s@gmail.com".formatted(e.customerId())));
    }

    private Function<Flux<OrderEvent>, Flux<PhysicalDelivery>> toPhysicalDelivery() {
        return flux -> flux.map(e -> new PhysicalDelivery(
                e.productId(),
                "%s street".formatted(e.customerId()),
                "%s city".formatted(e.customerId()),
                "some country"
        ));
    }

}

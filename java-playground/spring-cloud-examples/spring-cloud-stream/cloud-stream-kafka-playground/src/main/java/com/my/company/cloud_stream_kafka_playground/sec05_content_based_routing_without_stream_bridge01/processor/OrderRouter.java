package com.my.company.cloud_stream_kafka_playground.sec05_content_based_routing_without_stream_bridge01.processor;

import com.my.company.cloud_stream_kafka_playground.common.MessageConverter;
import com.my.company.cloud_stream_kafka_playground.sec05_content_based_routing_without_stream_bridge01.dto.DigitalDelivery;
import com.my.company.cloud_stream_kafka_playground.sec05_content_based_routing_without_stream_bridge01.dto.OrderEvent;
import com.my.company.cloud_stream_kafka_playground.sec05_content_based_routing_without_stream_bridge01.dto.PhysicalDelivery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import reactor.core.publisher.Flux;
import com.my.company.cloud_stream_kafka_playground.common.Record;

import java.util.function.Function;

@Configuration
@Slf4j
public class OrderRouter {

    private static final String DESTINATION_HEADER = "spring.cloud.stream.sendto.destination";
    private static final String DIGITAL_DELIVERY_CHANNEL = "digital-delivery-out";
    private static final String PHYSICAL_DELIVERY_CHANNEL = "physical-delivery-out";

    @Bean
    public Function<Flux<Message<OrderEvent>>, Flux<Message<?>>> processor01() {
        return flux -> flux
                .map(MessageConverter::toRecord)
                .map(this::route);
    }

    private Message<?> route(Record<OrderEvent> record) {
        var msg = switch (record.message().orderType()) {
            case DIGITAL -> this.toDigitalDelivery(record.message());
            case PHYSICAL -> this.toPhysicalDelivery(record.message());
        };
        record.acknowledgement().acknowledge();
        return msg;
    }

    private Message<DigitalDelivery> toDigitalDelivery(OrderEvent event) {
        var dd = new DigitalDelivery(event.productId(), "%s@gmail.com".formatted(event.customerId()));
        return MessageBuilder
                .withPayload(dd)
                .setHeader(DESTINATION_HEADER, DIGITAL_DELIVERY_CHANNEL)
                .build();
    }

    private Message<PhysicalDelivery> toPhysicalDelivery(OrderEvent event) {
        var pd = new PhysicalDelivery(
                event.productId(),
                "%s street".formatted(event.customerId()),
                "%s city".formatted(event.customerId()),
                "some country"
        );
        return MessageBuilder
                .withPayload(pd)
                .setHeader(DESTINATION_HEADER, PHYSICAL_DELIVERY_CHANNEL)
                .build();
    }

}

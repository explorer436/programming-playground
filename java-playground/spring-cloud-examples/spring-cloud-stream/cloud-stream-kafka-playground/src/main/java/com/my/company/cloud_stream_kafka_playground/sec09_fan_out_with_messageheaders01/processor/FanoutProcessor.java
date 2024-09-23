package com.my.company.cloud_stream_kafka_playground.sec09_fan_out_with_messageheaders01.processor;

import com.my.company.cloud_stream_kafka_playground.common.MessageConverter;
import com.my.company.cloud_stream_kafka_playground.common.Record;
import com.my.company.cloud_stream_kafka_playground.sec05_content_based_routing_with_stream_bridge01.dto.DigitalDelivery;
import com.my.company.cloud_stream_kafka_playground.sec05_content_based_routing_with_stream_bridge01.dto.OrderEvent;
import com.my.company.cloud_stream_kafka_playground.sec05_content_based_routing_with_stream_bridge01.dto.PhysicalDelivery;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;

import java.util.function.Function;

@Configuration
@Slf4j
public class FanoutProcessor {

    private static final String DESTINATION_HEADER = "spring.cloud.stream.sendto.destination";
    private static final String DIGITAL_DELIVERY_CHANNEL = "digital-topic";
    private static final String PHYSICAL_DELIVERY_CHANNEL = "physical-topic";

    @Bean
    public Function<Flux<Message<OrderEvent>>, Flux<Message<?>>> processor01() {
        return flux -> flux
                .map(MessageConverter::toRecord)
                .flatMap(this::route);
    }

    private Flux<Message<?>> route(Record<OrderEvent> record) {
        Flux<Message<?>> msg = switch (record.message().orderType()) {
            case DIGITAL -> this.toDigitalDelivery(record.message());
            case PHYSICAL -> this.toPhysicalDelivery(record.message());
        };
        record.acknowledgement().acknowledge();
        return msg;
    }

    private Flux<Message<?>> toDigitalDelivery(OrderEvent event) {
        Message<DigitalDelivery> ddMessage = getDigitalDeliveryMessage(event);

        Flux<Message<?>> result = Flux.just(ddMessage);

        return result;
    }

    private Message<DigitalDelivery> getDigitalDeliveryMessage(OrderEvent event) {
        DigitalDelivery dd = new DigitalDelivery(event.productId(), "%s@gmail.com".formatted(event.customerId()));
        Message<DigitalDelivery> ddMessage = MessageBuilder
                .withPayload(dd)
                .setHeader(DESTINATION_HEADER, DIGITAL_DELIVERY_CHANNEL)
                .build();
        return ddMessage;
    }

    /*
       One option to fan-out using message headers is, instead of returning on Message<>,
       return a Flux<> that has two messages.
     */
    private Flux<Message<?>> toPhysicalDelivery(OrderEvent event) {

        PhysicalDelivery pd = new PhysicalDelivery(
                event.productId(),
                "%s street".formatted(event.customerId()),
                "%s city".formatted(event.customerId()),
                "some country"
        );
        Message<PhysicalDelivery> pdMessage = MessageBuilder
                .withPayload(pd)
                .setHeader(DESTINATION_HEADER, PHYSICAL_DELIVERY_CHANNEL)
                .build();

        Flux<Message<?>> result = Flux.just(pdMessage, getDigitalDeliveryMessage(event));

        return result;
    }

}

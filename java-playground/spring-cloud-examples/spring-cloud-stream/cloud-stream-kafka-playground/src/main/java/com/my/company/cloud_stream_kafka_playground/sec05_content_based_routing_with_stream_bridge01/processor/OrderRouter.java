package com.my.company.cloud_stream_kafka_playground.sec05_content_based_routing_with_stream_bridge01.processor;

import com.my.company.cloud_stream_kafka_playground.common.MessageConverter;
import com.my.company.cloud_stream_kafka_playground.sec05_content_based_routing_with_stream_bridge01.dto.DigitalDelivery;
import com.my.company.cloud_stream_kafka_playground.sec05_content_based_routing_with_stream_bridge01.dto.OrderEvent;
import com.my.company.cloud_stream_kafka_playground.sec05_content_based_routing_with_stream_bridge01.dto.PhysicalDelivery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Configuration
@Slf4j
public class OrderRouter {

    // StreamBridge will look in the yaml file for a binding with this exact same name.
    // This is Content based routing using explicit binding.
    private static final String DIGITAL_DELIVERY_CHANNEL = "digital-delivery-out";
    private static final String PHYSICAL_DELIVERY_CHANNEL = "physical-delivery-out";

    @Autowired
    private StreamBridge streamBridge;

    @Bean
    public Function<Flux<Message<OrderEvent>>, Mono<Void>> processor01() {
        return flux -> flux
                .map(MessageConverter::toRecord)
                .doOnNext(r -> this.route(r.message()))
                .doOnNext(r -> r.acknowledgement().acknowledge())
                .then();
    }

    private void route(OrderEvent event) {
        switch (event.orderType()) {
            case DIGITAL -> this.toDigitalDelivery(event);
            case PHYSICAL -> this.toPhysicalDelivery(event);
        }
    }

    private void toDigitalDelivery(OrderEvent event) {
        DigitalDelivery dd = new DigitalDelivery(event.productId(), "%s@gmail.com".formatted(event.customerId()));
        log.info("dd: {}", dd.toString());
        this.streamBridge.send(DIGITAL_DELIVERY_CHANNEL, dd);
    }

    private void toPhysicalDelivery(OrderEvent event) {
        PhysicalDelivery pd = new PhysicalDelivery(
                event.productId(),
                "%s street".formatted(event.customerId()),
                "%s city".formatted(event.customerId()),
                "some country"
        );
        log.info("pd: {}", pd.toString());
        this.streamBridge.send(PHYSICAL_DELIVERY_CHANNEL, pd);
    }

}

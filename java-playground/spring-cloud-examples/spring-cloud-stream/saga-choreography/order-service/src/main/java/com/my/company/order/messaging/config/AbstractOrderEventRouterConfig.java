package com.my.company.order.messaging.config;

import com.my.company.common.events.DomainEvent;
import com.my.company.common.events.inventory.InventoryEvent;
import com.my.company.common.events.order.OrderEvent;
import com.my.company.common.processor.EventProcessor;
import com.my.company.common.util.MessageConverter;

import lombok.extern.slf4j.Slf4j;

import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import reactor.core.publisher.Flux;

import java.util.function.Function;

@Slf4j
public abstract class AbstractOrderEventRouterConfig {

    private static final String DESTINATION_HEADER = "spring.cloud.stream.sendto.destination";
    private static final String ORDER_EVENTS_CHANNEL = "order-events-channel";

    protected <T extends DomainEvent> Function<Flux<Message<T>>, Flux<Message<OrderEvent>>> processor(EventProcessor<T, OrderEvent> eventProcessor) {
        return flux -> flux.map(MessageConverter::toRecord)
                           .doOnNext(r -> log.info("order service received {}", r.message()))
                           .concatMap(r -> eventProcessor.process(r.message())
                                                              .doOnSuccess(e -> r.acknowledgement().acknowledge())
                           )
                           .map(this::toMessage);
    }

    /*
       Who uses this return of order-events? When do I use this "order-events-channel"?

       In the real life, there could be a lot more services that what we had considered in this course.
       For example, "notification-service" which may consume these order-completed events and sends emails to the users.
       Here, in this example, there is no service to consume.
     */
    protected Message<OrderEvent> toMessage(OrderEvent event) {
        log.info("order service produced {}", event);
        return MessageBuilder.withPayload(event)
                             .setHeader(KafkaHeaders.KEY, event.orderId().toString())
                             .setHeader(DESTINATION_HEADER, ORDER_EVENTS_CHANNEL)
                             .build();
    }
    
}

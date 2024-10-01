package com.my.company.shipping.messaging.processor;

import com.my.company.common.events.order.OrderEvent;
import com.my.company.common.events.shipping.ShippingEvent;
import com.my.company.common.exception.EventAlreadyProcessedException;
import com.my.company.common.processor.OrderEventProcessor;
import com.my.company.shipping.common.service.ShippingService;
import com.my.company.shipping.messaging.mapper.MessageDtoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.function.UnaryOperator;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderEventProcessorImpl implements OrderEventProcessor<ShippingEvent> {

    private final ShippingService service;

    @Override
    public Mono<ShippingEvent> handle(OrderEvent.OrderCreated event) {
        return this.service.addShipment(MessageDtoMapper.toScheduleRequest(event))
                           .transform(exceptionHandler())
                           .then(Mono.empty());
    }

    @Override
    public Mono<ShippingEvent> handle(OrderEvent.OrderCancelled event) {
        return this.service.cancel(event.orderId())
                           .then(Mono.empty());
    }

    @Override
    public Mono<ShippingEvent> handle(OrderEvent.OrderCompleted event) {
        return this.service.schedule(event.orderId())
                           .map(MessageDtoMapper::toShippingScheduledEvent)
                           .doOnNext(e -> log.info("shipping scheduled {}", e));
    }

    private <T> UnaryOperator<Mono<T>> exceptionHandler() {
        return mono -> mono.onErrorResume(EventAlreadyProcessedException.class, ex -> Mono.empty())
                           .doOnError(ex -> log.error(ex.getMessage()));
    }

}

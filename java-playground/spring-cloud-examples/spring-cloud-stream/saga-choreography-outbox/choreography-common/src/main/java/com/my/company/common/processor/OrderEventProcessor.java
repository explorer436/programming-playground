package com.my.company.common.processor;

import com.my.company.common.events.DomainEvent;
import com.my.company.common.events.order.OrderEvent;
import reactor.core.publisher.Mono;

public interface OrderEventProcessor<R extends DomainEvent> extends EventProcessor<OrderEvent, R> {

    @Override
    default Mono<R> process(OrderEvent event) {
        return switch (event){
            case OrderEvent.OrderCreated e -> this.handle(e);
            case OrderEvent.OrderCancelled e -> this.handle(e);
            case OrderEvent.OrderCompleted e -> this.handle(e);
        };
    }

    Mono<R> handle(OrderEvent.OrderCreated event);

    Mono<R> handle(OrderEvent.OrderCancelled event);

    Mono<R> handle(OrderEvent.OrderCompleted event);

}

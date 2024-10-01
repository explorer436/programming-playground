package com.my.company.order.messaging.publisher;

import com.my.company.common.events.order.OrderEvent;
import com.my.company.common.publisher.EventPublisher;
import com.my.company.order.common.dto.PurchaseOrderDto;
import com.my.company.order.common.service.OrderEventListener;
import com.my.company.order.messaging.mapper.OrderEventMapper;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.time.Duration;

/*
   Why doesn't this have @Service annotation?
   Because, this class needs Sink.
   Spring doesn't know how to create it.
   We have to create it ourselves - see OrderEventListenerConfig.
 */

//@Service
@RequiredArgsConstructor
public class OrderEventListenerImpl implements OrderEventListener, EventPublisher<OrderEvent> {

    private final Sinks.Many<OrderEvent> sink;
    private final Flux<OrderEvent> flux;

    @Override
    public Flux<OrderEvent> publish() {
        return this.flux;
    }

    @Override
    public void emitOrderCreated(PurchaseOrderDto dto) {
        OrderEvent event = OrderEventMapper.toOrderCreatedEvent(dto);
        // This is an alternative to using sink.tryEmitNext()
        // The difference is, emitNext() lets us define our own Sinks.EmitFailureHandler
        this.sink.emitNext(
                event,
                Sinks.EmitFailureHandler.busyLooping(Duration.ofSeconds(1))
        );
    }

}

package com.my.company.inventory.messaging.processor;

import com.my.company.common.events.inventory.InventoryEvent;
import com.my.company.common.events.order.OrderEvent;
import com.my.company.common.exception.EventAlreadyProcessedException;
import com.my.company.common.processor.OrderEventProcessor;
import com.my.company.inventory.common.service.InventoryService;
import com.my.company.inventory.messaging.mapper.MessageDtoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.function.UnaryOperator;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderEventProcessorImpl implements OrderEventProcessor<InventoryEvent> {

    private final InventoryService service;

    @Override
    public Mono<InventoryEvent> handle(OrderEvent.OrderCreated event) {
        return this.service.deduct(MessageDtoMapper.toInventoryDeductRequest(event))
                           .map(MessageDtoMapper::toInventoryDeductedEvent)
                           .doOnNext(e -> log.info("inventory deducted {}", e))
                           .transform(exceptionHandler(event));
    }

    @Override
    public Mono<InventoryEvent> handle(OrderEvent.OrderCancelled event) {
        return this.service.restore(event.orderId())
                           .map(MessageDtoMapper::toInventoryRestoredEvent)
                           .doOnNext(e -> log.info("inventory restored {}", e))
                           .doOnError(ex -> log.error("error while processing restore", ex));
    }

    @Override
    public Mono<InventoryEvent> handle(OrderEvent.OrderCompleted event) {
        return Mono.empty();
    }

    private UnaryOperator<Mono<InventoryEvent>> exceptionHandler(OrderEvent.OrderCreated event) {
        return mono -> mono.onErrorResume(EventAlreadyProcessedException.class, e -> Mono.empty())
                           .onErrorResume(MessageDtoMapper.toInventoryDeclinedEvent(event));
    }

}
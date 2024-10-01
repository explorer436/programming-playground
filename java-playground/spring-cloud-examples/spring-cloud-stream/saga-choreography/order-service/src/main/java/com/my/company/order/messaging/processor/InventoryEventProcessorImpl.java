package com.my.company.order.messaging.processor;

import com.my.company.common.events.inventory.InventoryEvent;
import com.my.company.common.events.order.OrderEvent;
import com.my.company.common.processor.InventoryEventProcessor;
import com.my.company.order.application.mapper.EntityDtoMapper;
import com.my.company.order.common.dto.OrderInventoryDto;
import com.my.company.order.common.service.OrderFulfillmentService;
import com.my.company.order.common.service.inventory.InventoryComponentStatusListener;
import com.my.company.order.messaging.mapper.InventoryEventMapper;
import com.my.company.order.messaging.mapper.OrderEventMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class InventoryEventProcessorImpl implements InventoryEventProcessor<OrderEvent> {

    private final OrderFulfillmentService fulfillmentService;
    private final InventoryComponentStatusListener statusListener;

    @Override
    public Mono<OrderEvent> handle(InventoryEvent.InventoryDeducted event) {
        OrderInventoryDto dto = InventoryEventMapper.toDto(event);
        return this.statusListener.onSuccess(dto)
                                  .then(this.fulfillmentService.complete(event.orderId()))
                                  .map(OrderEventMapper::toOrderCompletedEvent);
    }

    @Override
    public Mono<OrderEvent> handle(InventoryEvent.InventoryDeclined event) {
        OrderInventoryDto dto = InventoryEventMapper.toDto(event);
        return this.statusListener.onFailure(dto)
                                  .then(this.fulfillmentService.cancel(event.orderId()))
                                  .map(OrderEventMapper::toOrderCancelledEvent);
    }

    @Override
    public Mono<OrderEvent> handle(InventoryEvent.InventoryRestored event) {
        OrderInventoryDto dto = InventoryEventMapper.toDto(event);
        return this.statusListener.onRollback(dto)
                                  .then(Mono.empty());
    }

}

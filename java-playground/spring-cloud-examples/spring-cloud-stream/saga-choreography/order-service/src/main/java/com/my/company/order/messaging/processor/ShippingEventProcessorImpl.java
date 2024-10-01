package com.my.company.order.messaging.processor;

import com.my.company.common.events.order.OrderEvent;
import com.my.company.common.events.shipping.ShippingEvent;
import com.my.company.common.processor.ShippingEventProcessor;
import com.my.company.order.common.dto.OrderShipmentSchedule;
import com.my.company.order.common.service.shipping.ShippingComponentStatusListener;
import com.my.company.order.messaging.mapper.ShippingEventMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ShippingEventProcessorImpl implements ShippingEventProcessor<OrderEvent> {

    private final ShippingComponentStatusListener statusListener;

    @Override
    public Mono<OrderEvent> handle(ShippingEvent.ShippingScheduled event) {
        OrderShipmentSchedule dto = ShippingEventMapper.toDto(event);
        return this.statusListener.onSuccess(dto)
                .then(Mono.empty());
    }

}

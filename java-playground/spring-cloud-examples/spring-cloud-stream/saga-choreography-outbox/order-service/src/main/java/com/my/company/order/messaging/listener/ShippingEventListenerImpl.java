package com.my.company.order.messaging.listener;

import com.my.company.common.events.shipping.ShippingEvent;
import com.my.company.common.listener.ShippingEventListener;
import com.my.company.order.common.service.shipping.ShippingComponentStatusListener;
import com.my.company.order.messaging.mapper.ShippingEventMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ShippingEventListenerImpl implements ShippingEventListener {

    private final ShippingComponentStatusListener statusListener;

    @Override
    public Mono<Void> handle(ShippingEvent.ShippingScheduled event) {
        var dto = ShippingEventMapper.toDto(event);
        return this.statusListener.onSuccess(dto);
    }

}

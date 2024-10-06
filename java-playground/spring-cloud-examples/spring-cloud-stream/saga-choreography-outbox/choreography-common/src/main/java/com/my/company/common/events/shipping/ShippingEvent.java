package com.my.company.common.events.shipping;

import com.my.company.common.events.DomainEvent;
import com.my.company.common.events.OrderSaga;
import lombok.Builder;

import java.time.Instant;
import java.util.UUID;

public sealed interface ShippingEvent extends DomainEvent, OrderSaga {

    @Builder
    record ShippingScheduled(UUID orderId,
                             UUID shipmentId,
                             Instant expectedDelivery,
                             Instant createdAt) implements ShippingEvent {
    }


}

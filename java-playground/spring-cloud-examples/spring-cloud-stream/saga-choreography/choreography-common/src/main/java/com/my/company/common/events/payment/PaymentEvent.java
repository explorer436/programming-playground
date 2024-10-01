package com.my.company.common.events.payment;

import com.my.company.common.events.DomainEvent;
import com.my.company.common.events.OrderSaga;
import lombok.Builder;

import java.time.Instant;
import java.util.UUID;

/*
   OrderSage interface represents that this class participates in "Order" Saga.
   DomainEvent can contain other common utility methods.
 */
public sealed interface PaymentEvent extends DomainEvent, OrderSaga {

    /*
        Intentionally using primitive wrapper types to keep things simple
    */

    @Builder
    record PaymentDeducted(UUID orderId,
                           UUID paymentId,
                           Integer customerId,
                           Integer amount,
                           Instant createdAt) implements PaymentEvent {
    }

    @Builder
    record PaymentRefunded(UUID orderId,
                           UUID paymentId,
                           Integer customerId,
                           Integer amount,
                           Instant createdAt) implements PaymentEvent {
    }

    @Builder
    record PaymentDeclined(UUID orderId,
                           Integer customerId,
                           Integer amount,
                           String message,
                           Instant createdAt) implements PaymentEvent {
    }

}

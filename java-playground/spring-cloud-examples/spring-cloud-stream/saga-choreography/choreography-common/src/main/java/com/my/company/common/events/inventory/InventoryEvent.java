package com.my.company.common.events.inventory;

import com.my.company.common.events.DomainEvent;
import com.my.company.common.events.OrderSaga;
import lombok.Builder;

import java.time.Instant;
import java.util.UUID;

/*
   OrderSage interface represents that this class participates in "Order" Saga.
   DomainEvent can contain other common utility methods.
 */
public sealed interface InventoryEvent extends DomainEvent, OrderSaga {

    /*
       Intentionally using primitive wrapper types to keep things simple
    */

    @Builder
    record InventoryDeducted(UUID orderId,
                             UUID inventoryId,
                             Integer productId,
                             Integer quantity,
                             Instant createdAt) implements InventoryEvent {
    }

    @Builder
    record InventoryRestored(UUID orderId,
                             UUID inventoryId,
                             Integer productId,
                             Integer quantity,
                             Instant createdAt) implements InventoryEvent {
    }

    @Builder
    record InventoryDeclined(UUID orderId,
                             Integer productId,
                             Integer quantity,
                             String message,
                             Instant createdAt) implements InventoryEvent {
    }

}
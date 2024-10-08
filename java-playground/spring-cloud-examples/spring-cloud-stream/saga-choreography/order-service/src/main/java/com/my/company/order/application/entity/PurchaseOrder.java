package com.my.company.order.application.entity;

import com.my.company.common.events.order.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

import java.time.Instant;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseOrder {

    @Id
    private UUID orderId;
    private Integer customerId;
    private Integer productId;
    private Integer quantity;
    private Integer unitPrice;
    private Integer amount;
    private OrderStatus status;
    private Instant deliveryDate;

    // To implement "Optimistic locking"
    // If multiple events are marking the PurchaseOrder status to "Completed",
    // we will be emitting duplicate "Order complete" events.
    @Version
    private Integer version;
    // The application doesn't have to check for version numbers or implement any custom code.
    // All that is needed is to add this @Version annotation.
    // The framework will make sure that no concurrent writes are done to the table.
}

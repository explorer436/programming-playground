package com.my.company.order.common.dto;

import com.my.company.order.common.enums.OrderStatus;
import lombok.Builder;

import java.time.Instant;
import java.util.UUID;

@Builder
public record PurchaseOrderDto(UUID orderId,
                               Integer customerId,
                               Integer productId,
                               Integer unitPrice,
                               Integer quantity,
                               Integer amount,
                               OrderStatus status,
                               Instant deliveryDate) {
}

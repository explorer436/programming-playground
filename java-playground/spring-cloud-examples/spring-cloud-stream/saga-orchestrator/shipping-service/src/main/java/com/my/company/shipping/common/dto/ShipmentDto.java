package com.my.company.shipping.common.dto;

import com.my.company.common.messages.shipping.ShippingStatus;
import lombok.Builder;

import java.time.Instant;
import java.util.UUID;

@Builder
public record ShipmentDto(UUID shipmentId,
                          UUID orderId,
                          Integer productId,
                          Integer customerId,
                          Integer quantity,
                          Instant deliveryDate,
                          ShippingStatus status) {
}

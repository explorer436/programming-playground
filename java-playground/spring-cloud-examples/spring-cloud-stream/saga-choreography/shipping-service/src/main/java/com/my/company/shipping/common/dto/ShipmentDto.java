package com.my.company.shipping.common.dto;

import com.my.company.common.events.shipping.ShippingStatus;
import lombok.Builder;

import java.time.Instant;
import java.util.UUID;

@Builder
public record ShipmentDto(UUID shipmentId,
                          UUID orderId,
                          Integer productId,
                          Integer customerId,
                          Integer quantity,
                          Instant expectedDelivery,
                          ShippingStatus status) {
}

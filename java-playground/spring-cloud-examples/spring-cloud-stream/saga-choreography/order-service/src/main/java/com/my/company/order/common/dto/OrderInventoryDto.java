package com.my.company.order.common.dto;

import com.my.company.common.events.inventory.InventoryStatus;
import lombok.Builder;

import java.util.UUID;

@Builder
public record OrderInventoryDto(UUID orderId,
                                UUID inventoryId,
                                InventoryStatus status,
                                String message) {
}

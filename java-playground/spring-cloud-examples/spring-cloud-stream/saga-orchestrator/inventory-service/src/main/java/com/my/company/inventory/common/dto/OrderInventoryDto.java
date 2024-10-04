package com.my.company.inventory.common.dto;

import com.my.company.common.messages.inventory.InventoryStatus;
import lombok.Builder;

import java.util.UUID;

@Builder
public record OrderInventoryDto(UUID inventoryId,
                                UUID orderId,
                                Integer productId,
                                Integer quantity,
                                InventoryStatus status) {
}

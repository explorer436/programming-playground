package com.my.company.common.messages.inventory;

import com.my.company.common.messages.Request;
import lombok.Builder;

import java.util.UUID;

public sealed interface InventoryRequest extends Request {

    @Builder
    record Deduct(UUID orderId,
                  Integer productId,
                  Integer quantity) implements InventoryRequest {

    }

    @Builder
    record Restore(UUID orderId) implements InventoryRequest {

    }

}

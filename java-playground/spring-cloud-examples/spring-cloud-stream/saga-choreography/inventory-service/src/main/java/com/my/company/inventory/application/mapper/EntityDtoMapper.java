package com.my.company.inventory.application.mapper;

import com.my.company.inventory.application.entity.OrderInventory;
import com.my.company.inventory.common.dto.InventoryDeductRequest;
import com.my.company.inventory.common.dto.OrderInventoryDto;

public class EntityDtoMapper {

    public static OrderInventory toOrderInventory(InventoryDeductRequest request) {
        return OrderInventory.builder()
                             .orderId(request.orderId())
                             .productId(request.productId())
                             .quantity(request.quantity())
                             .build();
    }

    public static OrderInventoryDto toDto(OrderInventory orderInventory) {
        return OrderInventoryDto.builder()
                                .inventoryId(orderInventory.getInventoryId())
                                .orderId(orderInventory.getOrderId())
                                .productId(orderInventory.getProductId())
                                .quantity(orderInventory.getQuantity())
                                .status(orderInventory.getStatus())
                                .build();
    }

}

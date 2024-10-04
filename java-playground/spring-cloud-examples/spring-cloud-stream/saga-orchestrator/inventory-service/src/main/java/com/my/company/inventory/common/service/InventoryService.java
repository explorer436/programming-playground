package com.my.company.inventory.common.service;

import com.my.company.inventory.common.dto.InventoryDeductRequest;
import com.my.company.inventory.common.dto.OrderInventoryDto;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface InventoryService {

    Mono<OrderInventoryDto> deduct(InventoryDeductRequest request);

    Mono<OrderInventoryDto> restore(UUID orderId);

}

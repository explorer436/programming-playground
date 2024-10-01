package com.my.company.order.application.service;

import com.my.company.order.application.entity.OrderInventory;
import com.my.company.order.application.mapper.EntityDtoMapper;
import com.my.company.order.application.repository.OrderInventoryRepository;
import com.my.company.order.common.dto.OrderInventoryDto;
import com.my.company.order.common.service.inventory.InventoryComponentFetcher;
import com.my.company.order.common.service.inventory.InventoryComponentStatusListener;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InventoryComponentFetcherImpl implements InventoryComponentFetcher {

    private static final OrderInventoryDto DEFAULT = OrderInventoryDto.builder().build();
    private final OrderInventoryRepository repository;

    @Override
    public Mono<OrderInventoryDto> getComponent(UUID orderId) {
        return this.repository.findByOrderId(orderId)
                .map(EntityDtoMapper::toOrderInventoryDto)
                .defaultIfEmpty(DEFAULT);
    }
}

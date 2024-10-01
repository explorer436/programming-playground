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
public class InventoryComponentStatusListenerImpl implements InventoryComponentStatusListener {

    private final OrderInventoryRepository repository;

    @Override
    public Mono<Void> onSuccess(OrderInventoryDto message) {
        return this.repository.findByOrderId(message.orderId())
                              .switchIfEmpty(Mono.defer(() -> this.add(message, true)))
                              .then();
    }

    @Override
    public Mono<Void> onFailure(OrderInventoryDto message) {
        return this.repository.findByOrderId(message.orderId())
                              .switchIfEmpty(Mono.defer(() -> this.add(message, false)))
                              .then();
    }

    @Override
    public Mono<Void> onRollback(OrderInventoryDto message) {
        return this.repository.findByOrderId(message.orderId())
                              .doOnNext(e -> e.setStatus(message.status()))
                              .flatMap(this.repository::save)
                              .then();
    }

    private Mono<OrderInventory> add(OrderInventoryDto dto, boolean isSuccess) {
        var entity = EntityDtoMapper.toOrderInventory(dto);
        entity.setSuccess(isSuccess);
        return this.repository.save(entity);
    }

}

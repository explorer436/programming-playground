package com.my.company.order.application.service;

import com.my.company.order.application.entity.PurchaseOrder;
import com.my.company.order.application.mapper.EntityDtoMapper;
import com.my.company.order.application.repository.PurchaseOrderRepository;
import com.my.company.order.common.dto.OrderCreateRequest;
import com.my.company.order.common.dto.OrderDetails;
import com.my.company.order.common.dto.PurchaseOrderDto;
import com.my.company.order.common.service.OrderEventListener;
import com.my.company.order.common.service.OrderService;
import com.my.company.order.common.service.inventory.InventoryComponentFetcher;
import com.my.company.order.common.service.payment.PaymentComponentFetcher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final PurchaseOrderRepository repository;
    private final OrderEventListener eventListener;
    private final PaymentComponentFetcher paymentComponentFetcher;
    private final InventoryComponentFetcher inventoryComponentFetcher;

    @Override
    public Mono<PurchaseOrderDto> placeOrder(OrderCreateRequest request) {
        PurchaseOrder entity = EntityDtoMapper.toPurchaseOrder(request);
        return this.repository.save(entity)
                              .map(EntityDtoMapper::toPurchaseOrderDto)
                              .doOnNext(eventListener::emitOrderCreated);
    }

    @Override
    public Flux<PurchaseOrderDto> getAllOrders() {
        return this.repository.findAll()
                              .map(EntityDtoMapper::toPurchaseOrderDto);
    }

    @Override
    public Mono<OrderDetails> getOrderDetails(UUID orderId) {
        return this.repository.findById(orderId)
                              .map(EntityDtoMapper::toPurchaseOrderDto)
                              .flatMap(dto -> this.paymentComponentFetcher.getComponent(orderId)
                                                                          .zipWith(this.inventoryComponentFetcher.getComponent(orderId))
                                                                          .map(t -> EntityDtoMapper.toOrderDetails(dto, t.getT1(), t.getT2()))
                              );
    }

}

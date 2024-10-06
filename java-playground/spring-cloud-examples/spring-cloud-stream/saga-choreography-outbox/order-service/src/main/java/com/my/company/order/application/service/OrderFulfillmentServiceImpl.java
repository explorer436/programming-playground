package com.my.company.order.application.service;

import com.my.company.common.events.order.OrderStatus;
import com.my.company.order.application.entity.PurchaseOrder;
import com.my.company.order.application.mapper.EntityDtoMapper;
import com.my.company.order.application.repository.PurchaseOrderRepository;
import com.my.company.order.common.dto.PurchaseOrderDto;
import com.my.company.order.common.service.OrderEventListener;
import com.my.company.order.common.service.OrderFulfillmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import java.util.UUID;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class OrderFulfillmentServiceImpl implements OrderFulfillmentService {

    private final PurchaseOrderRepository repository;
    private final OrderEventListener orderEventListener;

    @Override
    public Mono<Void> complete(UUID orderId) {
        return this.repository.getWhenOrderComponentsCompleted(orderId)
                              .transform(this.updateStatus(OrderStatus.COMPLETED))
                              .flatMap(this.orderEventListener::onOrderCompleted);
    }

    @Override
    public Mono<Void> cancel(UUID orderId) {
        return this.repository.findByOrderIdAndStatus(orderId, OrderStatus.PENDING)
                              .transform(this.updateStatus(OrderStatus.CANCELLED))
                              .flatMap(this.orderEventListener::onOrderCancelled);
    }

    private Function<Mono<PurchaseOrder>, Mono<PurchaseOrderDto>> updateStatus(OrderStatus status) {
        return mono -> mono
                .doOnNext(e -> e.setStatus(status))
                .flatMap(this.repository::save)
                .retryWhen(Retry.max(1).filter(OptimisticLockingFailureException.class::isInstance))
                .map(EntityDtoMapper::toPurchaseOrderDto);
    }

}

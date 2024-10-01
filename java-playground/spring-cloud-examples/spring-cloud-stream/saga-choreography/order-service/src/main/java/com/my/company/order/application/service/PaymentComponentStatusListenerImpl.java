package com.my.company.order.application.service;

import com.my.company.order.application.entity.OrderPayment;
import com.my.company.order.application.mapper.EntityDtoMapper;
import com.my.company.order.application.repository.OrderPaymentRepository;
import com.my.company.order.common.dto.OrderPaymentDto;
import com.my.company.order.common.service.payment.PaymentComponentFetcher;
import com.my.company.order.common.service.payment.PaymentComponentStatusListener;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentComponentStatusListenerImpl implements PaymentComponentStatusListener {

    private final OrderPaymentRepository repository;

    @Override
    public Mono<Void> onSuccess(OrderPaymentDto message) {
        return this.repository.findByOrderId(message.orderId())
                              .switchIfEmpty(Mono.defer(() -> this.add(message, true)))
                              .then();
    }

    @Override
    public Mono<Void> onFailure(OrderPaymentDto message) {
        return this.repository.findByOrderId(message.orderId())
                              .switchIfEmpty(Mono.defer(() -> this.add(message, false)))
                              .then();
    }

    @Override
    public Mono<Void> onRollback(OrderPaymentDto message) {
        return this.repository.findByOrderId(message.orderId())
                              .doOnNext(e -> e.setStatus(message.status()))
                              .flatMap(this.repository::save)
                              .then();
    }

    private Mono<OrderPayment> add(OrderPaymentDto dto, boolean isSuccess) {
        var entity = EntityDtoMapper.toOrderPayment(dto);
        entity.setSuccess(isSuccess);
        return this.repository.save(entity);
    }

}

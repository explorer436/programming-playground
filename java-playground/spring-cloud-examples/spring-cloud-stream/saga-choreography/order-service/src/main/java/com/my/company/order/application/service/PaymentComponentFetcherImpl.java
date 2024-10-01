package com.my.company.order.application.service;

import com.my.company.order.application.mapper.EntityDtoMapper;
import com.my.company.order.application.repository.OrderPaymentRepository;
import com.my.company.order.common.dto.OrderPaymentDto;
import com.my.company.order.common.service.payment.PaymentComponentFetcher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentComponentFetcherImpl implements PaymentComponentFetcher  {

    private static final OrderPaymentDto DEFAULT = OrderPaymentDto.builder().build();
    private final OrderPaymentRepository repository;

    @Override
    public Mono<OrderPaymentDto> getComponent(UUID orderId) {
        return this.repository.findByOrderId(orderId)
                .map(EntityDtoMapper::toOrderPaymentDto)
                .defaultIfEmpty(DEFAULT);
    }
}

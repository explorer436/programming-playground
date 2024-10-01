package com.my.company.payment.application.repository;

import com.my.company.payment.application.entity.CustomerPayment;
import com.my.company.common.events.payment.PaymentStatus;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Repository
public interface PaymentRepository extends ReactiveCrudRepository<CustomerPayment, UUID> {

    Mono<Boolean> existsByOrderId(UUID orderId);

    Mono<CustomerPayment> findByOrderIdAndStatus(UUID orderId, PaymentStatus status);

}

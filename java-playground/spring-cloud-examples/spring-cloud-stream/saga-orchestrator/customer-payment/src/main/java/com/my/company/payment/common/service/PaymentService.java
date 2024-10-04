package com.my.company.payment.common.service;

import com.my.company.payment.common.dto.PaymentDto;
import com.my.company.payment.common.dto.PaymentProcessRequest;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface PaymentService {

    Mono<PaymentDto> process(PaymentProcessRequest request);

    Mono<PaymentDto> refund(UUID orderId);

}

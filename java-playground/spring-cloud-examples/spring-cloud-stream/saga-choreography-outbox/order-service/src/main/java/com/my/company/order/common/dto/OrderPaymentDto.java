package com.my.company.order.common.dto;

import com.my.company.common.events.payment.PaymentStatus;
import lombok.Builder;

import java.util.UUID;

@Builder
public record OrderPaymentDto(UUID orderId,
                              UUID paymentId,
                              PaymentStatus status,
                              String message) {
}

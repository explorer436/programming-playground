package com.my.company.order.messaging.mapper;

import com.my.company.common.events.payment.PaymentEvent;
import com.my.company.common.events.payment.PaymentStatus;
import com.my.company.order.common.dto.OrderPaymentDto;

public class PaymentEventMapper {

    public static OrderPaymentDto toDto(PaymentEvent.PaymentDeducted event) {
        return OrderPaymentDto.builder()
                                    .orderId(event.orderId())
                                    .paymentId(event.paymentId())
                                    .status(PaymentStatus.DEDUCTED)
                                    .build();
    }

    public static OrderPaymentDto toDto(PaymentEvent.PaymentDeclined event) {
        return OrderPaymentDto.builder()
                                    .orderId(event.orderId())
                                    .status(PaymentStatus.DECLINED)
                                    .message(event.message())
                                    .build();
    }

    public static OrderPaymentDto toDto(PaymentEvent.PaymentRefunded event) {
        return OrderPaymentDto.builder()
                                    .orderId(event.orderId())
                                    .status(PaymentStatus.REFUNDED)
                                    .build();
    }

}

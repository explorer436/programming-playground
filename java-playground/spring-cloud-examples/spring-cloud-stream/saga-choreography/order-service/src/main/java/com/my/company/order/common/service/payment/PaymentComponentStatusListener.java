package com.my.company.order.common.service.payment;

import com.my.company.order.common.dto.OrderPaymentDto;
import com.my.company.order.common.service.OrderComponentStatusListener;

public interface PaymentComponentStatusListener extends OrderComponentStatusListener<OrderPaymentDto> {
}

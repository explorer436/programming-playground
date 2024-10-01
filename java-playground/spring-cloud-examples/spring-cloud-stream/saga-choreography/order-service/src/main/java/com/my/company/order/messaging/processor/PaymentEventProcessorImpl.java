package com.my.company.order.messaging.processor;

import com.my.company.common.events.order.OrderEvent;
import com.my.company.common.events.payment.PaymentEvent;
import com.my.company.common.processor.PaymentEventProcessor;
import com.my.company.order.common.dto.OrderPaymentDto;
import com.my.company.order.common.service.OrderFulfillmentService;
import com.my.company.order.common.service.payment.PaymentComponentStatusListener;
import com.my.company.order.messaging.mapper.OrderEventMapper;
import com.my.company.order.messaging.mapper.PaymentEventMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PaymentEventProcessorImpl implements PaymentEventProcessor<OrderEvent> {

    private final OrderFulfillmentService fulfillmentService;
    private final PaymentComponentStatusListener statusListener;

    @Override
    public Mono<OrderEvent> handle(PaymentEvent.PaymentDeducted event) {
        OrderPaymentDto dto = PaymentEventMapper.toDto(event);
        return this.statusListener.onSuccess(dto)
                                  .then(this.fulfillmentService.complete(event.orderId()))
                                  .map(OrderEventMapper::toOrderCompletedEvent);
    }

    @Override
    public Mono<OrderEvent> handle(PaymentEvent.PaymentDeclined event) {
        OrderPaymentDto dto = PaymentEventMapper.toDto(event);
        return this.statusListener.onFailure(dto)
                                  .then(this.fulfillmentService.cancel(event.orderId()))
                                  .map(OrderEventMapper::toOrderCancelledEvent);
    }

    @Override
    public Mono<OrderEvent> handle(PaymentEvent.PaymentRefunded event) {
        OrderPaymentDto dto = PaymentEventMapper.toDto(event);
        return this.statusListener.onRollback(dto)
                                  .then(Mono.empty());
    }
}

package com.my.company.common.processor;

import com.my.company.common.events.DomainEvent;
import com.my.company.common.events.payment.PaymentEvent;
import reactor.core.publisher.Mono;

public interface PaymentEventProcessor<R extends DomainEvent> extends EventProcessor<PaymentEvent, R> {

    /*
       This is a much better way than using if-else condition on each incoming event.
       For alternative approaches, see alternativetopatternmatching.
     */
    @Override
    default Mono<R> process(PaymentEvent event) {
        return switch (event) {
            case PaymentEvent.PaymentDeducted e -> this.handle(e);
            case PaymentEvent.PaymentDeclined e -> this.handle(e);
            case PaymentEvent.PaymentRefunded e -> this.handle(e);
        };
    }

    Mono<R> handle(PaymentEvent.PaymentDeducted event);

    Mono<R> handle(PaymentEvent.PaymentDeclined event);

    Mono<R> handle(PaymentEvent.PaymentRefunded event);

}

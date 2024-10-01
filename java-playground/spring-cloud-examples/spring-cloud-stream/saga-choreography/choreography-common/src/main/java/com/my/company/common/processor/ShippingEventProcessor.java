package com.my.company.common.processor;

import com.my.company.common.events.DomainEvent;
import com.my.company.common.events.shipping.ShippingEvent;
import reactor.core.publisher.Mono;

public interface ShippingEventProcessor<R extends DomainEvent> extends EventProcessor<ShippingEvent, R> {

    /*
       This is a much better way than using if-else condition on each incoming event.
       For alternative approaches, see alternativetopatternmatching.
     */

    /*
        Even though there is only one type of ShippingEvent (ShippingScheduled),
        we are following the same pattern that is used in the other processor interfaces.

        Also, with this approach, we will be passing the ShippingScheduled event to handle() - not ShippingEvent.
     */

    @Override
    default Mono<R> process(ShippingEvent event) {
        return switch (event) {
            case ShippingEvent.ShippingScheduled e -> this.handle(e);
        };
    }

    Mono<R> handle(ShippingEvent.ShippingScheduled event);

}

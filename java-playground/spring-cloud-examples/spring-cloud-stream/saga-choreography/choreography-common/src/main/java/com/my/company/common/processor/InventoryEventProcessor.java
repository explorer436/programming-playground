package com.my.company.common.processor;

import com.my.company.common.events.DomainEvent;
import com.my.company.common.events.inventory.InventoryEvent;
import reactor.core.publisher.Mono;

public interface InventoryEventProcessor<R extends DomainEvent> extends EventProcessor<InventoryEvent, R> {

    /*
       This is a much better way than using if-else condition on each incoming event.
       For alternative approaches, see alternativetopatternmatching.
     */
    @Override
    default Mono<R> process(InventoryEvent event) {
        return switch (event) {
            case InventoryEvent.InventoryDeducted e -> this.handle(e);
            case InventoryEvent.InventoryDeclined e -> this.handle(e);
            case InventoryEvent.InventoryRestored e -> this.handle(e);
        };
    }

    Mono<R> handle(InventoryEvent.InventoryDeducted event);

    Mono<R> handle(InventoryEvent.InventoryDeclined event);

    Mono<R> handle(InventoryEvent.InventoryRestored event);

}

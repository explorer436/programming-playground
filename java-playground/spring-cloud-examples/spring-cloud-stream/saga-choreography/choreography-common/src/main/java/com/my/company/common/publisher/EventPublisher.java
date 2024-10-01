package com.my.company.common.publisher;

import com.my.company.common.events.DomainEvent;
import reactor.core.publisher.Flux;

/*
    This interface is used by the sub-modules to "publish" the events to the messaging platforms.
 */

public interface EventPublisher<T extends DomainEvent> {

    Flux<T> publish();

}

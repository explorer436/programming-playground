package com.my.company.common.processor;

import com.my.company.common.events.DomainEvent;
import reactor.core.publisher.Mono;

public interface EventProcessor<T extends DomainEvent, R extends DomainEvent> {

    Mono<R> process(T event);

}

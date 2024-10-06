package com.my.company.common.listener;

import com.my.company.common.events.DomainEvent;
import reactor.core.publisher.Mono;

public interface EventListener<T extends DomainEvent> {

    Mono<Void> listen(T event);

}

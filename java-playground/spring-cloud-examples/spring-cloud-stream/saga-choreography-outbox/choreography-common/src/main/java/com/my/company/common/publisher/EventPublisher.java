package com.my.company.common.publisher;

import com.my.company.common.events.DomainEvent;
import com.my.company.common.outbox.Outbox;
import reactor.core.publisher.Flux;

public interface EventPublisher<T extends DomainEvent> {

    Flux<Outbox<T>> publish();

}

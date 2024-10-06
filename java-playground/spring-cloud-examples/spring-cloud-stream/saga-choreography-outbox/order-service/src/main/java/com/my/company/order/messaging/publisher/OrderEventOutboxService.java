package com.my.company.order.messaging.publisher;

import com.my.company.common.events.order.OrderEvent;
import com.my.company.common.publisher.EventPublisher;
import reactor.core.publisher.Mono;

import java.util.List;

public interface OrderEventOutboxService extends EventPublisher<OrderEvent> {

    Mono<Void> deleteEvents(List<Long> ids);

}

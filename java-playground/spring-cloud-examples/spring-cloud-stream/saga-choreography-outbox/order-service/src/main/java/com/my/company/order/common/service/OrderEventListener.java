package com.my.company.order.common.service;

import com.my.company.order.common.dto.PurchaseOrderDto;
import reactor.core.publisher.Mono;

public interface OrderEventListener {

    Mono<Void> onOrderCreated(PurchaseOrderDto dto);

    Mono<Void> onOrderCancelled(PurchaseOrderDto dto);

    Mono<Void> onOrderCompleted(PurchaseOrderDto dto);

}

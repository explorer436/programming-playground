package com.my.company.order.common.service;

import reactor.core.publisher.Mono;

/*

   order-service will be listening to the output topics of the sub-modules "customer-payment", "inventory-service" and "shipping-service".
   Why?
   After receiving messages from those sub-modules, "order-service" updates its own tables with the latest details about that purchase-order like shipping date, etc.

   This interface is to define methods for those listeners.
   This interface is extended by the interfaces
   1. PaymentComponentStatusListener
   2. InventoryComponentStatusListener
   3. ShippingComponentStatusListener

 */
public interface OrderComponentStatusListener<T> {

    Mono<Void> onSuccess(T message);

    Mono<Void> onFailure(T message);

    Mono<Void> onRollback(T message);

}

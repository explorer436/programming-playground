package com.my.company.order.common.service;

import reactor.core.publisher.Mono;

import java.util.UUID;

/*

   There are different components to an "order"
   1. payment
   2. inventory
   3. shipment

   The details about those components and "purchase orders" are stored in the tables
   1. OrderPayment
   2. OrderInventory
   3. PurchaseOrder

   This is a common interface to fetch details about them.
   This interface is extended by
   1. InventoryComponentFetcher and
   2. PaymentComponentFetcher

 */
public interface OrderComponentFetcher<T> {

    Mono<T> getComponent(UUID orderId);

}

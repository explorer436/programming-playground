package com.my.company.order.common.service;

import com.my.company.order.common.dto.OrderCreateRequest;
import com.my.company.order.common.dto.OrderDetails;
import com.my.company.order.common.dto.PurchaseOrderDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface OrderService {

    Mono<PurchaseOrderDto> placeOrder(OrderCreateRequest request);

    Flux<PurchaseOrderDto> getAllOrders();

    Mono<OrderDetails> getOrderDetails(UUID orderId);

}

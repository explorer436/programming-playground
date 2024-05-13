package com.example.assignment.service;

import io.grpc.stub.StreamObserver;
import io.quarkus.grpc.GrpcService;
import lombok.RequiredArgsConstructor;
import openapitools.OrderOuterClass;
import openapitools.OrdersOuterClass;
import openapitools.services.ordersservice.OrdersServiceGrpc;
import openapitools.services.ordersservice.OrdersServiceOuterClass;
import org.springframework.beans.factory.annotation.Value;

@GrpcService
@RequiredArgsConstructor
public class OrdersGrpcService extends OrdersServiceGrpc.OrdersServiceImplBase {

    @Value("${points.tier1.purchaseAmount}")
    private int pointsTier1PurchaseAmount;

    @Value("${points.tier1.perDollar}")
    private int pointsTier1PerDollar;

    @Value("${points.tier2.purchaseAmount}")
    private int pointsTier2PurchaseAmount;

    @Value("${points.tier2.perDollar}")
    private int pointsTier2PerDollar;

    @Override
    public void getOrdersByCustomerId(OrdersServiceOuterClass.GetOrdersByCustomerIdRequest request, StreamObserver<OrdersOuterClass.Orders> responseObserver) {
        String customerId = request.getCustomerId();

        OrdersOuterClass.Orders response = getOrders(customerId);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    private OrdersOuterClass.Orders getOrders(String customerId) {

        OrderOuterClass.Order order1 = OrderOuterClass.Order.newBuilder()
                .setItemDescription("item 1 description")
                .setItemName("item 1 name")
                .setPurchaseAmount(100.0)
                .build();
        OrderOuterClass.Order order2 = OrderOuterClass.Order.newBuilder()
                .setItemDescription("item 2 description")
                .setItemName("item 2 name")
                .setPurchaseAmount(200.0)
                .build();
        OrderOuterClass.Order order3 = OrderOuterClass.Order.newBuilder()
                .setItemDescription("item 3 description")
                .setItemName("item 3 name")
                .setPurchaseAmount(300.0)
                .build();

        OrdersOuterClass.Orders orders = OrdersOuterClass.Orders.newBuilder()
                .addOrders(order1)
                .addOrders(order2)
                .addOrders(order3)
                .build();

        return orders;
    }


}

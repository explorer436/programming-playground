package com.example.assignment.service;

import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import openapitools.OrdersOuterClass;
import openapitools.services.ordersservice.OrdersServiceOuterClass;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringBootTest
@SpringJUnitConfig(classes = { MyServiceUnitTestConfiguration.class })
@Slf4j
// Spring doesn't start without a config (might be empty)
// Don't use @EnableAutoConfiguration in this scenario
public class OrdersGrpcServiceTests {

    @Autowired
    private OrdersGrpcService ordersGrpcService;

    @Test
    void test_getOrders() throws Exception {
        OrdersServiceOuterClass.GetOrdersByCustomerIdRequest request = OrdersServiceOuterClass.GetOrdersByCustomerIdRequest.newBuilder()
                .setCustomerId("1")
                .build();

        StreamObserver<OrdersOuterClass.Orders> responseObserver = new StreamObserver<OrdersOuterClass.Orders>() {
            @Override
            public void onNext(OrdersOuterClass.Orders orders) {
                log.info("onNext");
                log.info(orders.toString());
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onCompleted() {
                log.info("onCompleted");
            }
        };

        ordersGrpcService.getOrdersByCustomerId(request, responseObserver);
    }
}

package com.example.assignment.api.impl;

import com.example.assignment.rewards.api.OrdersApiDelegate;
import com.example.assignment.rewards.model.Order;
import com.example.assignment.rewards.model.Orders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class OrdersApiDelegateImpl implements OrdersApiDelegate {
    @Override
    public ResponseEntity<Orders> getOrdersByCustomerId(String customerId) {


        Order order1 = Order.builder()
                .itemDescription("item 1 description")
                .itemName("item 1 name")
                .purchaseAmount(100.0).build();

        Order order2 = Order.builder()
                .itemDescription("item 2 description")
                .itemName("item 2 name")
                .purchaseAmount(200.0).build();

        Order order3 = Order.builder()
                .itemDescription("item 3 description")
                .itemName("item 3 name")
                .purchaseAmount(300.0).build();

        Orders orders = Orders.builder()
                .orders(Arrays.asList(order1, order2, order3))
                .build();

        return ResponseEntity.ok(orders);
    }

    @Override
    public ResponseEntity<Orders> postOrdersByCustomerId(String customerId) {
        return OrdersApiDelegate.super.postOrdersByCustomerId(customerId);
    }
}

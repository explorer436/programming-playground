package com.example.assignment.api.impl;

import com.example.assignment.rewards.api.OrdersApiDelegate;
import com.example.assignment.rewards.model.Order;
import com.example.assignment.rewards.model.Orders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OrdersApiDelegateImpl implements OrdersApiDelegate {
    @Override
    public ResponseEntity<Orders> getOrdersByCustomerId(String customerId) {
        Orders orders = new Orders();

        Order order1 = new Order();
        order1.setItemDescription("item 1 description");
        order1.setItemName("item 1 name");
        order1.setPurchaseAmount(100.0);
        orders.addOrdersItem(order1);

        Order order2 = new Order();
        order2.setItemDescription("item 2 description");
        order2.setItemName("item 2 name");
        order2.setPurchaseAmount(200.0);
        orders.addOrdersItem(order2);

        Order order3 = new Order();
        order3.setItemDescription("item 3 description");
        order3.setItemName("item 3 name");
        order3.setPurchaseAmount(300.0);
        orders.addOrdersItem(order3);

        return ResponseEntity.ok(orders);
    }

    @Override
    public ResponseEntity<Orders> postOrdersByCustomerId(String customerId) {
        return OrdersApiDelegate.super.postOrdersByCustomerId(customerId);
    }
}

package com.my.company.order;

import com.my.company.order.common.dto.OrderCreateRequest;

public class TestDataUtil {

    public static OrderCreateRequest toRequest(int customerId, int productId, int unitPrice, int quantity) {
        return OrderCreateRequest.builder()
                                 .unitPrice(unitPrice)
                                 .quantity(quantity)
                                 .customerId(customerId)
                                 .productId(productId)
                                 .build();
    }

}

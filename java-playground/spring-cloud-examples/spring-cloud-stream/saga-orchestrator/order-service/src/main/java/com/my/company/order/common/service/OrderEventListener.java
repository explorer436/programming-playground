package com.my.company.order.common.service;

import com.my.company.order.common.dto.PurchaseOrderDto;

public interface OrderEventListener {

    void emitOrderCreated(PurchaseOrderDto dto);

}

package com.my.company.order.common.service.shipping;

import com.my.company.order.common.dto.OrderShipmentSchedule;
import com.my.company.order.common.service.OrderComponentStatusListener;

public interface ShippingComponentStatusListener extends OrderComponentStatusListener<OrderShipmentSchedule> {
}

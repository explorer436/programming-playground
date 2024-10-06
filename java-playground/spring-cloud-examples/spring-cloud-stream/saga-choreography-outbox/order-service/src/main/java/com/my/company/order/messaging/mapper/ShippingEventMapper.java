package com.my.company.order.messaging.mapper;


import com.my.company.common.events.shipping.ShippingEvent;
import com.my.company.order.common.dto.OrderShipmentSchedule;

public class ShippingEventMapper {

    public static OrderShipmentSchedule toDto(ShippingEvent.ShippingScheduled event) {
        return OrderShipmentSchedule.builder()
                                    .orderId(event.orderId())
                                    .deliveryDate(event.expectedDelivery())
                                    .build();
    }

}

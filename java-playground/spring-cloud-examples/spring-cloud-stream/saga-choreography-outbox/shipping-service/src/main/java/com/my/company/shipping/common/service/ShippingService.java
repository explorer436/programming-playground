package com.my.company.shipping.common.service;

import com.my.company.shipping.common.dto.ScheduleRequest;
import com.my.company.shipping.common.dto.ShipmentDto;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface ShippingService {

    Mono<Void> addShipment(ScheduleRequest request);

    Mono<Void> cancel(UUID orderId);

    Mono<ShipmentDto> schedule(UUID orderId);

}


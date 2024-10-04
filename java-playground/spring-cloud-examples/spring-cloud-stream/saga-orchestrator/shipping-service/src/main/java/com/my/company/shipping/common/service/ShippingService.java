package com.my.company.shipping.common.service;

import com.my.company.shipping.common.dto.ScheduleRequest;
import com.my.company.shipping.common.dto.ShipmentDto;
import reactor.core.publisher.Mono;

public interface ShippingService {

    Mono<ShipmentDto> schedule(ScheduleRequest request);

}


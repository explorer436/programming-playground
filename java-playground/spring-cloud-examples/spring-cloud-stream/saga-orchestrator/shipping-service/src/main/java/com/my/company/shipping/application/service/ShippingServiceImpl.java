package com.my.company.shipping.application.service;

import com.my.company.common.messages.shipping.ShippingStatus;
import com.my.company.common.util.DuplicateEventValidator;
import com.my.company.shipping.application.entity.Shipment;
import com.my.company.shipping.application.mapper.EntityDtoMapper;
import com.my.company.shipping.application.repository.ShipmentRepository;
import com.my.company.shipping.common.dto.ScheduleRequest;
import com.my.company.shipping.common.dto.ShipmentDto;
import com.my.company.shipping.common.exception.ShipmentQuantityLimitExceededException;
import com.my.company.shipping.common.service.ShippingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.Instant;

@Service
@RequiredArgsConstructor
public class ShippingServiceImpl implements ShippingService {

    private static final Mono<Shipment> LIMIT_EXCEEDED = Mono.error(new ShipmentQuantityLimitExceededException());
    private final ShipmentRepository repository;

    @Override
    public Mono<ShipmentDto> schedule(ScheduleRequest request) {
        return DuplicateEventValidator.validate(
                                              this.repository.existsByOrderId(request.orderId()),
                                              Mono.just(request)
                                      )
                                      .filter(r -> r.quantity() < 10)
                                      .map(EntityDtoMapper::toShipment)
                                      .switchIfEmpty(LIMIT_EXCEEDED)
                                      .flatMap(this::schedule);
    }

    private Mono<ShipmentDto> schedule(Shipment shipment) {
        shipment.setDeliveryDate(Instant.now().plus(Duration.ofDays(3)));
        shipment.setStatus(ShippingStatus.SCHEDULED);
        return this.repository.save(shipment)
                              .map(EntityDtoMapper::toDto);
    }

}

package com.my.company.shipping.application.service;

import com.my.company.common.events.shipping.ShippingStatus;
import com.my.company.common.validation.DuplicateEventValidator;
import com.my.company.shipping.application.entity.Shipment;
import com.my.company.shipping.application.mapper.EntityDtoMapper;
import com.my.company.shipping.application.repository.ShipmentRepository;
import com.my.company.shipping.common.dto.ScheduleRequest;
import com.my.company.shipping.common.dto.ShipmentDto;
import com.my.company.shipping.common.service.ShippingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.Instant;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ShippingServiceImpl implements ShippingService {

    private final ShipmentRepository repository;

    /*@Override
    public Mono<Void> addShipment(ScheduleRequest request) {
        return DuplicateEventValidator.validate(
                this.repository.existsByOrderId(request.orderId()),
                Mono.defer(() -> this.add(request))
        );
    }*/

    @Override
    public Mono<Void> addShipment(ScheduleRequest request) {
        return DuplicateEventValidator.validate(
                        this.repository.existsByOrderId(request.orderId())
                )
                .then(Mono.defer(() -> this.add(request))
                );
    }

    private Mono<Void> add(ScheduleRequest request) {
        Shipment shipment = EntityDtoMapper.toShipment(request);
        shipment.setStatus(ShippingStatus.PENDING);
        return this.repository.save(shipment)
                              .then();
    }

    @Override
    public Mono<Void> cancel(UUID orderId) {
        return this.repository.deleteByOrderId(orderId);
    }

    @Override
    public Mono<ShipmentDto> schedule(UUID orderId) {
        return this.repository.findByOrderIdAndStatus(orderId, ShippingStatus.PENDING)
                              .flatMap(this::schedule);
    }

    private Mono<ShipmentDto> schedule(Shipment shipment) {
        shipment.setDeliveryDate(Instant.now().plus(Duration.ofDays(3)));
        shipment.setStatus(ShippingStatus.SCHEDULED);
        return this.repository.save(shipment)
                              .map(EntityDtoMapper::toDto);
    }

}
package com.my.company.shipping.application.repository;

import com.my.company.common.events.shipping.ShippingStatus;
import com.my.company.shipping.application.entity.Shipment;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Repository
public interface ShipmentRepository extends ReactiveCrudRepository<Shipment, UUID> {

    Mono<Boolean> existsByOrderId(UUID orderId);

    Mono<Shipment> findByOrderIdAndStatus(UUID orderId, ShippingStatus status);

    Mono<Void> deleteByOrderId(UUID orderId);

}
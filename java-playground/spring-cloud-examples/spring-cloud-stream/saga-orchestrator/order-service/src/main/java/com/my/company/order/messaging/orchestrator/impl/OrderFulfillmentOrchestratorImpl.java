package com.my.company.order.messaging.orchestrator.impl;

import com.my.company.common.messages.Request;
import com.my.company.common.messages.inventory.InventoryResponse;
import com.my.company.common.messages.payment.PaymentResponse;
import com.my.company.common.messages.shipping.ShippingResponse;
import com.my.company.common.publisher.EventPublisher;
import com.my.company.order.common.service.OrderFulfillmentService;
import com.my.company.order.messaging.orchestrator.InventoryStep;
import com.my.company.order.messaging.orchestrator.OrderFulfillmentOrchestrator;
import com.my.company.order.messaging.orchestrator.PaymentStep;
import com.my.company.order.messaging.orchestrator.ShippingStep;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderFulfillmentOrchestratorImpl implements OrderFulfillmentOrchestrator {

    private final PaymentStep paymentStep;
    private final InventoryStep inventoryStep;
    private final ShippingStep shippingStep;
    private final OrderFulfillmentService service;
    private final EventPublisher<UUID> eventPublisher;
    private Workflow workflow;

    @PostConstruct
    private void init() {
        this.workflow = Workflow.startWith(paymentStep)
                                .thenNext(inventoryStep)
                                .thenNext(shippingStep)
                                .doOnFailure(id -> this.service.cancel(id).then())
                                .doOnSuccess(id -> this.service.complete(id).then()); // last step. or create it as builder

//        this.paymentStep.setPreviousStep(id -> this.service.cancel(id).then(Mono.empty()));
//        this.paymentStep.setNextStep(inventoryStep);
//        this.inventoryStep.setPreviousStep(paymentStep);
//        this.inventoryStep.setNextStep(shippingStep);
//        this.shippingStep.setPreviousStep(inventoryStep);
//        this.shippingStep.setNextStep(id -> this.service.complete(id).then(Mono.empty()));
    }

    /*
       We have to create the initial request.
       The request from OrderEventListenerImpl.emitOrderCreated() will be sent here by OrderFulfillmentOrchestratorConfig.
    */
    @Override
    public Publisher<Request> orderInitialRequests() {
        return this.eventPublisher.publish()
                                  .flatMap(this.workflow.getFirstStep()::send);
    }

    @Override
    public Publisher<Request> handle(PaymentResponse response) {
        return this.paymentStep.process(response);
    }

    @Override
    public Publisher<Request> handle(InventoryResponse response) {
        return this.inventoryStep.process(response);
    }

    @Override
    public Publisher<Request> handle(ShippingResponse response) {
        return this.shippingStep.process(response);
    }

}

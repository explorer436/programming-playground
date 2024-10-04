package com.my.company.order.messaging.orchestrator;

import com.my.company.common.messages.Request;
import com.my.company.common.messages.Response;
import com.my.company.common.messages.inventory.InventoryResponse;
import com.my.company.common.messages.payment.PaymentResponse;
import com.my.company.common.messages.shipping.ShippingResponse;
import com.my.company.common.orchestrator.WorkflowOrchestrator;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Mono;

public interface OrderFulfillmentOrchestrator extends WorkflowOrchestrator {

    Publisher<Request> orderInitialRequests();

    @Override
    default Publisher<Request> orchestrate(Response response) {
        return switch (response) {
            case PaymentResponse r -> this.handle(r);
            case InventoryResponse r -> this.handle(r);
            case ShippingResponse r -> this.handle(r);
            default -> Mono.empty();
        };
    }

    Publisher<Request> handle(PaymentResponse response);

    Publisher<Request> handle(InventoryResponse response);

    Publisher<Request> handle(ShippingResponse response);

}

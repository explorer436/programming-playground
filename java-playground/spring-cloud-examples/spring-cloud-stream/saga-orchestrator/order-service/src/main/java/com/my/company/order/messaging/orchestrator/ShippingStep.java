package com.my.company.order.messaging.orchestrator;

import com.my.company.common.messages.Request;
import com.my.company.common.messages.shipping.ShippingResponse;
import com.my.company.common.orchestrator.WorkflowStep;
import org.reactivestreams.Publisher;

public interface ShippingStep extends WorkflowStep<ShippingResponse> {

    @Override
    default Publisher<Request> process(ShippingResponse response) {
        return switch (response){
            case ShippingResponse.Scheduled r -> this.onSuccess(r);
            case ShippingResponse.Declined r -> this.onFailure(r);
        };
    }

    Publisher<Request> onSuccess(ShippingResponse.Scheduled response);

    Publisher<Request> onFailure(ShippingResponse.Declined response);

}

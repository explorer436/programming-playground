package com.my.company.order.messaging.orchestrator;

import com.my.company.common.messages.Request;
import com.my.company.common.messages.payment.PaymentResponse;
import com.my.company.common.orchestrator.WorkflowStep;
import org.reactivestreams.Publisher;

public interface PaymentStep extends WorkflowStep<PaymentResponse> {

    @Override
    default Publisher<Request> process(PaymentResponse response) {
        return switch (response){
            case PaymentResponse.Processed r -> this.onSuccess(r);
            case PaymentResponse.Declined r -> this.onFailure(r);
        };
    }

    Publisher<Request> onSuccess(PaymentResponse.Processed response);

    Publisher<Request> onFailure(PaymentResponse.Declined response);

}

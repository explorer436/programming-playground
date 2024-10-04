package com.my.company.shipping.messaging.processor;

import com.my.company.common.messages.shipping.ShippingRequest;
import com.my.company.common.messages.shipping.ShippingResponse;
import com.my.company.common.processor.RequestProcessor;
import reactor.core.publisher.Mono;

public interface ShippingRequestProcessor extends RequestProcessor<ShippingRequest, ShippingResponse> {

    @Override
    default Mono<ShippingResponse> process(ShippingRequest request) {
        return switch (request){
            case ShippingRequest.Schedule s -> this.handle(s);
        };
    }

    Mono<ShippingResponse> handle(ShippingRequest.Schedule request);

}

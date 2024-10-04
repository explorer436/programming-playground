package com.my.company.inventory.messaging.processor;

import com.my.company.common.messages.inventory.InventoryRequest;
import com.my.company.common.messages.inventory.InventoryResponse;
import com.my.company.common.processor.RequestProcessor;
import reactor.core.publisher.Mono;

public interface InventoryRequestProcessor extends RequestProcessor<InventoryRequest, InventoryResponse> {

    @Override
    default Mono<InventoryResponse> process(InventoryRequest request) {
        return switch (request){
            case InventoryRequest.Deduct r -> this.handle(r);
            case InventoryRequest.Restore r -> this.handle(r);
        };
    }

    Mono<InventoryResponse> handle(InventoryRequest.Deduct request);

    Mono<InventoryResponse> handle(InventoryRequest.Restore request);

}

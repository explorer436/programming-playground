package com.my.company.order.messaging.config;

import com.my.company.common.messages.Request;
import com.my.company.common.messages.Response;
import com.my.company.common.messages.inventory.InventoryRequest;
import com.my.company.common.messages.payment.PaymentRequest;
import com.my.company.common.messages.shipping.ShippingRequest;
import com.my.company.common.util.MessageConverter;
import com.my.company.order.messaging.orchestrator.OrderFulfillmentOrchestrator;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import reactor.core.publisher.Flux;

import java.util.function.Function;

@Configuration
@RequiredArgsConstructor
public class OrderFulfillmentOrchestratorConfig {

    private static final Logger log = LoggerFactory.getLogger(OrderFulfillmentOrchestratorConfig.class);
    private static final String DESTINATION_HEADER = "spring.cloud.stream.sendto.destination";
    private static final String PAYMENT_REQUEST_CHANNEL = "payment-request-channel";
    private static final String INVENTORY_REQUEST_CHANNEL = "inventory-request-channel";
    private static final String SHIPPING_REQUEST_CHANNEL = "shipping-request-channel";
    private final OrderFulfillmentOrchestrator orchestrator;

    @Bean
    public Function<Flux<Message<Response>>, Flux<Message<Request>>> orderOrchestrator() {
        return flux -> flux.map(MessageConverter::toRecord)
                           .doOnNext(r -> log.info("order service received {}", r.message()))
                           .concatMap(r -> Flux.from(orchestrator.orchestrate(r.message()))
                                               .doAfterTerminate(() -> r.acknowledgement().acknowledge())
                           )
                           // to handle initial request in the workflow.
                           .mergeWith(orchestrator.orderInitialRequests())
                           .map(this::toMessage);
    }

    protected Message<Request> toMessage(Request request) {
        log.info("order service produced {}", request);
        return MessageBuilder.withPayload(request)
                             .setHeader(KafkaHeaders.KEY, request.orderId().toString())
                             .setHeader(DESTINATION_HEADER, getDestination(request))
                             .build();
    }

    /*
       Determine topic name based on the type of the request.
    */
    private String getDestination(Request request) {
        return switch (request) {
            case PaymentRequest r -> PAYMENT_REQUEST_CHANNEL;
            case InventoryRequest r -> INVENTORY_REQUEST_CHANNEL;
            case ShippingRequest r -> SHIPPING_REQUEST_CHANNEL;
            default -> throw new IllegalStateException("Unexpected value: " + request);
        };
    }

}

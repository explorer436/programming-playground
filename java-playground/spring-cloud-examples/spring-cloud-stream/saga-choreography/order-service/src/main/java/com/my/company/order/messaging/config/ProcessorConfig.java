package com.my.company.order.messaging.config;

import com.my.company.common.events.inventory.InventoryEvent;
import com.my.company.common.events.order.OrderEvent;
import com.my.company.common.events.payment.PaymentEvent;
import com.my.company.common.events.shipping.ShippingEvent;
import com.my.company.common.processor.EventProcessor;
import com.my.company.common.publisher.EventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import reactor.core.publisher.Flux;

import java.util.function.Function;
import java.util.function.Supplier;

@Configuration
@RequiredArgsConstructor
public class ProcessorConfig extends AbstractOrderEventRouterConfig {

    private final EventProcessor<InventoryEvent, OrderEvent> inventoryEventProcessor;
    private final EventProcessor<PaymentEvent, OrderEvent> paymentEventProcessor;
    private final EventProcessor<ShippingEvent, OrderEvent> shippingEventProcessor;

    private final EventPublisher<OrderEvent> eventPublisher;

    /*
       The bindings for each of these are defined in application.yaml file.
     */

    @Bean
    public Function<Flux<Message<InventoryEvent>>, Flux<Message<OrderEvent>>> inventoryProcessor(){
        return this.processor(inventoryEventProcessor);
    }

    @Bean
    public Function<Flux<Message<PaymentEvent>>, Flux<Message<OrderEvent>>> paymentProcessor(){
        return this.processor(paymentEventProcessor);
    }

    @Bean
    public Function<Flux<Message<ShippingEvent>>, Flux<Message<OrderEvent>>> shippingProcessor(){
        return this.processor(shippingEventProcessor);
    }

    @Bean
    public Supplier<Flux<Message<OrderEvent>>> orderEventProducer() {
        return () -> this.eventPublisher.publish()
                                        .map(this::toMessage);
    }

}

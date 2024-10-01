package com.my.company.order.messaging.config;

import com.my.company.common.events.order.OrderEvent;
import com.my.company.order.common.service.OrderEventListener;
import com.my.company.order.messaging.publisher.OrderEventListenerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@Configuration
public class OrderEventListenerConfig {

    /*
       We are not using spring @Service annotation in OrderEventListenerImpl.
       Instead, we need to define this bean to initialize that class.
     */

    @Bean
    public OrderEventListener orderEventListener(){
        Sinks.Many<OrderEvent> sink = Sinks.many().unicast().<OrderEvent>onBackpressureBuffer();
        Flux<OrderEvent> flux = sink.asFlux();
        return new OrderEventListenerImpl(sink, flux);
    }

}

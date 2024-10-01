package com.my.company.order.messaging.config;

import com.my.company.common.events.payment.PaymentEvent;
import com.my.company.common.events.order.OrderEvent;
import com.my.company.common.processor.PaymentEventProcessor;
import com.my.company.common.util.MessageConverter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import reactor.core.publisher.Flux;

import java.util.function.Function;

/*@Configuration
@RequiredArgsConstructor
@Slf4j
public class PaymentEventProcessorConfig {

    private final PaymentEventProcessor<OrderEvent> eventProcessor;

    @Bean
    public Function<Flux<Message<PaymentEvent>>, Flux<Message<OrderEvent>>> processor() {
        return flux -> flux.map(MessageConverter::toRecord)
                           .doOnNext(r -> log.info("order service received {}", r.message()))
                           .concatMap(r -> this.eventProcessor.process(r.message())
                                                              .doOnSuccess(e -> r.acknowledgement().acknowledge())
                           )
                           .map(this::toMessage);
    }

    private Message<OrderEvent> toMessage(OrderEvent event) {
        return MessageBuilder.withPayload(event)
                             .setHeader(KafkaHeaders.KEY, event.orderId().toString())
                             .build();
    }

}*/

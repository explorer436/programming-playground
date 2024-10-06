package com.my.company.order.messaging.config;

import com.my.company.common.events.order.OrderEvent;
import com.my.company.common.outbox.Outbox;
import com.my.company.order.messaging.publisher.OrderEventOutboxService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.IntegrationMessageHeaderAccessor;
import org.springframework.integration.channel.FluxMessageChannel;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import reactor.core.publisher.Flux;
import reactor.kafka.sender.SenderResult;

import java.time.Duration;
import java.util.function.Supplier;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class OrderEventPublisherConfig {

    private final OrderEventOutboxService orderEventOutboxService;

    /*
        The rows that are already processed need to be deleted from the Outbox table.
        If not, we will be processing the same rows again and again.
     */
    @Bean
    @SuppressWarnings("unchecked")
    public FluxMessageChannel orderEventResults() {
        FluxMessageChannel channel = new FluxMessageChannel();
        Flux.from(channel)
            .map(m -> (SenderResult<Long>) m.getPayload())
            .map(SenderResult::correlationMetadata)
                // don't delete each row separately. Batch them.
                // But this time should be smaller than the value used in orderEventProducer().
            .bufferTimeout(1000, Duration.ofMillis(100)) // use config
            .doOnNext(list -> log.info("deleting ids {}", list))
            .flatMap(this.orderEventOutboxService::deleteEvents)
            .subscribe();
        return channel;
    }

    @Bean
    public Supplier<Flux<Message<OrderEvent>>> orderEventProducer() {
        return () -> this.orderEventOutboxService.publish()
                                                 //   .repeatWhen(f -> f.delayElements(Duration.ofMillis(1000))) // use config
                                                 .map(this::toMessage);
    }

    private Message<OrderEvent> toMessage(Outbox<OrderEvent> outbox) {
        log.info("order service produced {}", outbox.event());
        return MessageBuilder.withPayload(outbox.event())
                             .setHeader(KafkaHeaders.KEY, outbox.event().orderId().toString())
                             .setHeader(IntegrationMessageHeaderAccessor.CORRELATION_ID, outbox.correlationId())
                             .build();
    }

}

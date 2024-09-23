package com.my.company.cloud_stream_kafka_playground.sec06_content_based_routing_using_message_headers01.consumer;

import com.my.company.cloud_stream_kafka_playground.common.MessageConverter;
import com.my.company.cloud_stream_kafka_playground.common.Record;
import com.my.company.cloud_stream_kafka_playground.sec05_content_based_routing_with_stream_bridge01.dto.DigitalDelivery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Slf4j
@Configuration
public class DigitalDeliveryConsumer {

    @Bean
    public Function<Flux<Message<DigitalDelivery>>, Mono<Void>> digitalDeliveryConsumer01() {
        return flux -> flux
                .map(MessageConverter::toRecord)
                .doOnNext(this::printDetails)
                .then();
    }

    private void printDetails(Record<DigitalDelivery> record) {
        log.info("digital consumer {}", record.message());
        record.acknowledgement().acknowledge();
    }

}

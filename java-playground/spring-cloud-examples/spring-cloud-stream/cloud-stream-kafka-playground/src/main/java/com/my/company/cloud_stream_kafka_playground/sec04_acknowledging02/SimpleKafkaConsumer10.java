package com.my.company.cloud_stream_kafka_playground.sec04_acknowledging02;

/*
    goal: to demo a simple kafka consumer using java functional interfaces
 */

import com.my.company.cloud_stream_kafka_playground.common.MessageConverter;
import com.my.company.cloud_stream_kafka_playground.common.Record;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import reactor.core.publisher.Flux;

import java.util.function.Consumer;

@Configuration
@Slf4j
public class SimpleKafkaConsumer10 {

    @Bean
    public Consumer<Flux<Message<String>>> consumer10() {
        return flux -> flux
                .map(MessageConverter::toRecord)
                .doOnNext(this::printMessageDetails)
                .subscribe();
    }

    private void printMessageDetails(Record<String> record) {
        log.info("payload: {}", record.message());
        log.info("key: {}", record.key());
        record.acknowledgement().acknowledge();

    }

}

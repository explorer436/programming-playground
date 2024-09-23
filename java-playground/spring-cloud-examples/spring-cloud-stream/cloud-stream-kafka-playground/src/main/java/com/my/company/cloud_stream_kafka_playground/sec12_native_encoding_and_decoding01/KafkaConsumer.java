package com.my.company.cloud_stream_kafka_playground.sec12_native_encoding_and_decoding01;

/*
    goal: to demo native encoding/decoding
 */

import com.my.company.cloud_stream_kafka_playground.sec12_native_encoding_and_decoding01.dto.ContactMethod;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import reactor.core.publisher.Flux;

import java.util.function.Consumer;

@Configuration
@Slf4j
public class KafkaConsumer {

    @Bean
    public Consumer<Flux<Message<ContactMethod>>> consumer() {
        return flux -> flux
                .doOnNext(s -> log.info("consumer received {}", s))
                .subscribe();
    }

}

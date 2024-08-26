package kafka.examples.reactive.kafka.standalone.examples.withspring;

import kafka.examples.reactive.kafka.standalone.examples.withspring.model.DummyOrder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.kafka.core.reactive.ReactiveKafkaConsumerTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class MyConsumerRunner implements CommandLineRunner {

    // See OrderEventConsumerTest.java
    private final ReactiveKafkaConsumerTemplate<String, DummyOrder> dummyOrderConsumerTemplate;
    // private final ReactiveKafkaConsumerTemplate<String, OrderEvent> orderEventConsumerTemplate;

    @Override
    public void run(String... args) throws Exception {
        dummyOrderConsumerTemplate
                .receive()
                //        .doOnNext(r -> r.headers().forEach(h -> log.info("header key: {}, value: {}", h.key(), new String(h.value()))))
                .doOnNext(r -> log.info("key: {}, value: {}", r.key(), r.value()))
                .subscribe();
    }
}
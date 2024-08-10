package kafka.examples.reactive.kafka.playground.dead_letter_topics;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import reactor.core.publisher.Mono;
import reactor.kafka.receiver.ReceiverRecord;
import reactor.kafka.sender.KafkaSender;
import reactor.kafka.sender.SenderOptions;
import reactor.util.retry.Retry;

import java.time.Duration;
import java.util.Map;

@Slf4j
public class OrderEventProcessor {

    private static ReactiveDeadLetterTopicProducer<String, String> deadLetterTopicProducer() {
        var producerConfig = Map.<String, Object>of(
                ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092",
                ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class,
                ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class
        );
        var options = SenderOptions.<String, String>create(producerConfig);
        var sender = KafkaSender.create(options);
        return new ReactiveDeadLetterTopicProducer<>(
                sender,
                Retry.fixedDelay(2, Duration.ofSeconds(1))
        );
    }

    public Mono<Void> process(ReceiverRecord<String, String> record) {
        return Mono.just(record)
                .doOnNext(r -> {
                    if (r.key().endsWith("5")) {
                        throw new RuntimeException("processing exception");
                    }
                    log.info("key: {}, value: {}", r.key(), r.value());
                    r.receiverOffset().acknowledge();
                })
                .onErrorMap(ex -> new RecordProcessingException(record, ex))
                .transform(this.deadLetterTopicProducer().recordProcessingErrorHandler());
    }

}

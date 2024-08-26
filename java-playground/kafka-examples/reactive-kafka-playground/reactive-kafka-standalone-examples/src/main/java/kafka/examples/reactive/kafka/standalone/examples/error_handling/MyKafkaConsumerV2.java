package kafka.examples.reactive.kafka.standalone.examples.error_handling;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import reactor.core.publisher.Mono;
import reactor.kafka.receiver.KafkaReceiver;
import reactor.kafka.receiver.ReceiverOptions;
import reactor.kafka.receiver.ReceiverRecord;
import reactor.util.retry.Retry;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class MyKafkaConsumerV2 {

    public static void main(String[] args) {

        var consumerConfig = Map.<String, Object>of(
                ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:8081",
                ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class,
                ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class,
                ConsumerConfig.GROUP_ID_CONFIG, "demo-group",
                ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest",
                ConsumerConfig.GROUP_INSTANCE_ID_CONFIG, "1"
        );

        var options = ReceiverOptions.create(consumerConfig)
                .subscription(List.of("first_kafka_topic"));

        KafkaReceiver.create(options)
                .receive()
                .log()
                .concatMap(MyKafkaConsumerV2::process)
                .subscribe();

    }

    private static Mono<Void> process(ReceiverRecord<Object, Object> receiverRecord){
        return Mono.just(receiverRecord)
                .doOnNext(r -> {
                    // try to produce index out of bounds error in a random way
                    var index = ThreadLocalRandom.current().nextInt(1, 100);
                    log.info("key: {}, index: {}, value: {}", r.key(), index, r.value().toString().toCharArray()[index]);
                })
                .retryWhen(Retry.fixedDelay(3, Duration.ofSeconds(1)).onRetryExhaustedThrow((spec, signal) -> signal.failure()))
                .doOnError(ex -> log.error(ex.getMessage()))
                .doFinally(s -> receiverRecord.receiverOffset().acknowledge())
                .onErrorComplete()
                .then();
    }
}

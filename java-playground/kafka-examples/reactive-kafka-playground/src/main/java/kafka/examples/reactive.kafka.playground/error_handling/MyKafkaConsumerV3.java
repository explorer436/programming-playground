package kafka.examples.reactive.kafka.playground.error_handling;

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
public class MyKafkaConsumerV3 {

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
                .concatMap(MyKafkaConsumerV3::process)
                .subscribe();

    }

    private static Mono<Void> process(ReceiverRecord<Object, Object> receiverRecord){
        return Mono.just(receiverRecord)
                .doOnNext(r -> {
                    if(r.key().toString().equals("5")) {
                        // try to produce DB is down error in a random way
                        throw new RuntimeException("DB is down");
                    }
                    var index = ThreadLocalRandom.current().nextInt(1, 20);
                    log.info("key: {}, index: {}, value: {}", r.key(), index, r.value().toString().toCharArray()[index]);
                    r.receiverOffset().acknowledge();
                })
                .retryWhen(retrySpec())
                .doOnError(ex -> log.error(ex.getMessage()))
                .onErrorResume(IndexOutOfBoundsException.class, ex -> Mono.fromRunnable(() -> receiverRecord.receiverOffset().acknowledge()))
                .then();
    }

    private static Retry retrySpec(){
        return Retry.fixedDelay(3, Duration.ofSeconds(1))
                .filter(IndexOutOfBoundsException.class::isInstance)
                .onRetryExhaustedThrow((spec, signal) -> signal.failure());
    }
}

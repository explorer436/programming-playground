package kafka.examples.reactive.kafka.standalone.examples.batch_or_parallel_processing;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.kafka.receiver.KafkaReceiver;
import reactor.kafka.receiver.ReceiverOptions;

import java.time.Duration;
import java.util.List;
import java.util.Map;

@Slf4j
public class MyKafkaConsumerWithConcatMap {

    public static void main(String[] args) {

        Map<String, Object> consumerConfig = Map.<String, Object>of(
                ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092",
                ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class,
                ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class,
                ConsumerConfig.GROUP_ID_CONFIG, "demo-group",
                ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest",
                ConsumerConfig.GROUP_INSTANCE_ID_CONFIG, "1",

                // One major difference compared to other classes

                ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 3
        );

        ReceiverOptions<Object, Object> options = ReceiverOptions.create(consumerConfig)
                .commitInterval(Duration.ofSeconds(1))
                .subscription(List.of("order-events"));

        /**
         goal: receiveAutoAck with concatMap

         instead of using .receive().doOnNext().subscribe();
         */
        KafkaReceiver.create(options)
                .receiveAutoAck()
                .log()
                .concatMap(MyKafkaConsumerWithConcatMap::batchProcess)
                .subscribe();
    }

    private static Mono<Void> batchProcess(Flux<ConsumerRecord<Object, Object>> flux) {
        return flux
                .doFirst(() -> log.info("----------------"))
                .doOnNext(r -> log.info("key: {}, value: {}", r.key(), r.value()))
                .then(Mono.delay(Duration.ofSeconds(1)))
                .then();
    }

}
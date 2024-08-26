package kafka.examples.reactive.kafka.standalone.examples.batch_or_parallel_processing;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.GroupedFlux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.kafka.receiver.KafkaReceiver;
import reactor.kafka.receiver.ReceiverOptions;
import reactor.kafka.receiver.ReceiverRecord;

import java.time.Duration;
import java.util.List;
import java.util.Map;

@Slf4j
public class MyKafkaConsumerWithGroupBy {

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

        ReceiverOptions<String, String> options = ReceiverOptions.<String, String>create(consumerConfig)
                .commitInterval(Duration.ofSeconds(1))
                .subscription(List.of("order-events"));

        /**
         goal: receiveAutoAck with concatMap

         instead of using .receive().doOnNext().subscribe();
         */
        KafkaReceiver.create(options)
                .receive()
                .log()
                .groupBy(r -> Integer.parseInt(r.key()) % 5) // just for demo
                // we can also group by r.partition()
                // r.key().hashCode() % 5
                .flatMap(MyKafkaConsumerWithGroupBy::batchProcess)
                .subscribe();
    }

    private static Mono<Void> batchProcess(GroupedFlux<Integer, ReceiverRecord<String, String>> flux){

        // This is to do the processing in a separate thread pool.

        return flux
                .publishOn(Schedulers.boundedElastic()) // just for demo
                .doFirst(() -> log.info("----------------mod: {}", flux.key()))
                .doOnNext(r -> log.info("key: {}, value: {}", r.key(), r.value()))
                .doOnNext(r -> r.receiverOffset().acknowledge())
                .then();
    }

}
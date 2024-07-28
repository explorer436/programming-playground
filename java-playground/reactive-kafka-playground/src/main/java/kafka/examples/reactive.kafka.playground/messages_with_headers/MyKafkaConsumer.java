package kafka.examples.reactive.kafka.playground.messages_with_headers;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.OffsetResetStrategy;
import org.apache.kafka.common.serialization.StringDeserializer;
import reactor.kafka.receiver.KafkaReceiver;
import reactor.kafka.receiver.ReceiverOptions;

import java.util.List;
import java.util.Map;

@Slf4j
public class MyKafkaConsumer {

    // In order to start listening, just start the main method.
    public static void main(String[] args) {

        Map<String, Object> consumerConfig = Map.<String, Object>of(
                ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092",
                ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class,
                ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class,
                ConsumerConfig.GROUP_ID_CONFIG, "demo-group-123",
                ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, OffsetResetStrategy.EARLIEST.toString(),
                ConsumerConfig.GROUP_INSTANCE_ID_CONFIG, "1"
        );

        ReceiverOptions<Object, Object> options = ReceiverOptions
                .create(consumerConfig)
                // we can consume from more than one topics
                .subscription(List.of("order-events", "order-returns"));
                // .subscription(Pattern.compile("order.*"));

        KafkaReceiver.create(options)
                .receive()
                .doOnNext(r -> log.info("topic: {}, key: {}, value: {}", r.topic(), r.key(), r.value()))
                .doOnNext(r -> r.headers().forEach(h -> log.info("header key: {}, value: {}", h.key(), new String(h.value()))))
                // acknowledge after processing the message. Not before.
                .doOnNext(r -> r.receiverOffset().acknowledge())
                .subscribe();

        // Don't we have to block this thread?
        // No, this does not run on the main thread.
        // It runs on a daemon thread. And it will keep listening on the daemon thread.
    }
}

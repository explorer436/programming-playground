package kafka.examples.reactive.kafka.playground.consumer_groups.seeking_offset;

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

        ReceiverOptions<Object, Object> options = ReceiverOptions.create(consumerConfig)
                .addAssignListener(c -> {
                    c.forEach(r -> log.info("assigned {}", r.position()));
                    c.stream()
                            .filter(r -> r.topicPartition().partition() == 0)
                            .findFirst()
                            .ifPresent(r -> r.seek(r.position() - 2));  // seek value can not be -ve. ensure before setting
                })
                .subscription(List.of("order-events"));

        KafkaReceiver.create(options)
                .receive()
                .doOnNext(r -> log.info("topic: {}, key: {}, value: {}", r.topic(), r.key(), r.value()))
                // acknowledge after processing the message. Not before.
                .doOnNext(r -> r.receiverOffset().acknowledge())
                .subscribe();
    }
}
    

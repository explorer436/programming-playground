package kafka.examples.reactive.kafka.playground.poison_pill_errors;

import java.util.List;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.OffsetResetStrategy;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import reactor.kafka.receiver.KafkaReceiver;
import reactor.kafka.receiver.ReceiverOptions;

@Slf4j
public class MyKafkaConsumer {

    public static void main(String[] args) {

        var consumerConfig = Map.<String, Object>of(
                ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092",
                ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class,
                // ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, IntegerDeserializer.class,
                ConsumerConfig.GROUP_ID_CONFIG, "demo-group",
                ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest",
                ConsumerConfig.GROUP_INSTANCE_ID_CONFIG, "1"
        );

        var options = ReceiverOptions.<String, Integer>create(consumerConfig)
                .withValueDeserializer(errorHandlingDeserializer())
                .subscription(List.of("order-events"));

        KafkaReceiver.create(options)
                .receive()
                .doOnNext(r -> log.info("key: {}, value: {}", r.key(), r.value()))
                .doOnNext(r -> r.receiverOffset().acknowledge())
                .subscribe();

    }

    private static ErrorHandlingDeserializer<Integer> errorHandlingDeserializer(){
        var deserializer = new ErrorHandlingDeserializer<>(new IntegerDeserializer());
        deserializer.setFailedDeserializationFunction(
                info -> {
                    log.error("failed record: {}", new String(info.getData()));
                    return -10_000;
                }
        );
        return deserializer;
    }

}

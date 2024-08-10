package kafka.examples.reactive.kafka.playground.dead_letter_topics;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import reactor.kafka.receiver.KafkaReceiver;
import reactor.kafka.receiver.ReceiverOptions;

import java.util.List;
import java.util.Map;

@Slf4j
public class MyKafkaConsumer {

    public static void main(String[] args) {

        var processor = new OrderEventProcessor();
        var receiver = kafkaReceiver();

        receiver.receive()
                .concatMap(processor::process)
                .subscribe();

    }



    private static KafkaReceiver<String, String> kafkaReceiver(){
        var consumerConfig = Map.<String, Object>of(
                ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092",
                ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class,
                ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class,
                ConsumerConfig.GROUP_ID_CONFIG, "demo-group",
                ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest",
                ConsumerConfig.GROUP_INSTANCE_ID_CONFIG, "1"
        );
        var options = ReceiverOptions.<String, String>create(consumerConfig)
                .subscription(List.of("order-events", "order-events-dlt"));
        return KafkaReceiver.create(options);
    }
}

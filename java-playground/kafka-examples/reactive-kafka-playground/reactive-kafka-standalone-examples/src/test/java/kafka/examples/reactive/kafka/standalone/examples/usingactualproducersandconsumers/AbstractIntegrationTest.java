package kafka.examples.reactive.kafka.standalone.examples.usingactualproducersandconsumers;

import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.kafka.test.EmbeddedKafkaBroker;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.kafka.test.utils.KafkaTestUtils;
import reactor.kafka.receiver.KafkaReceiver;
import reactor.kafka.receiver.ReceiverOptions;
import reactor.kafka.sender.KafkaSender;
import reactor.kafka.sender.SenderOptions;
import reactor.kafka.sender.SenderRecord;

import java.util.List;
import java.util.Map;
import java.util.function.UnaryOperator;

@SpringBootTest
@EmbeddedKafka(
        partitions = 1,
        topics = { "order-events" },
        bootstrapServersProperty = "spring.kafka.bootstrapServers"
)
public abstract class AbstractIntegrationTest {

    @Autowired
    private EmbeddedKafkaBroker broker;

    protected <V> KafkaReceiver<String, V> createReceiver(String trustedPackages, String... topics){
        return createReceiver(options ->
                options.withKeyDeserializer(new StringDeserializer())
                        .withValueDeserializer(new JsonDeserializer<V>().trustedPackages(trustedPackages))
                        .subscription(List.of(topics))
        );
    }

    protected <K, V> KafkaReceiver<K, V> createReceiver(UnaryOperator<ReceiverOptions<K, V>> builder){
        Map<String, Object> props = KafkaTestUtils.consumerProps("test-group", "true", broker);
        ReceiverOptions<K, V> options = ReceiverOptions.<K, V>create(props);
        options = builder.apply(options);
        return KafkaReceiver.create(options);
    }

    protected <V> KafkaSender<String, V> createSender(){
        return createSender(options ->
                options.withKeySerializer(new StringSerializer())
                        .withValueSerializer(new JsonSerializer<V>())
        );
    }

    private <K, V> KafkaSender<K, V> createSender(UnaryOperator<SenderOptions<K, V>> builder){
        Map<String, Object> props = KafkaTestUtils.producerProps(broker);
        SenderOptions<K, V> options = SenderOptions.<K, V>create(props);
        options = builder.apply(options);
        return KafkaSender.create(options);
    }

    protected <K,V> SenderRecord<K, V, K> toSenderRecord(String topic, K key, V value){
        return SenderRecord.create(topic, null, null, key, value, key);
    }

}
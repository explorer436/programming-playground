package kafka.examples.reactive.kafka.playground.consumer_groups;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import reactor.core.publisher.Flux;
import reactor.kafka.sender.KafkaSender;
import reactor.kafka.sender.SenderOptions;
import reactor.kafka.sender.SenderRecord;

import java.time.Duration;
import java.util.Map;

@Slf4j
public class MyKafkaProducer {
    public static void main(String[] args) {

        Map<String, Object> producerConfig = Map.<String, Object>of(
                ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092",
                ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class,
                ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class
        );
        var senderOptions = SenderOptions.<String, String>create(producerConfig);

        var flux = Flux.interval(Duration.ofMillis(50))
                .take(10_000)
                .map(i -> new ProducerRecord<>("order-events", i.toString(), "order-"+i))
                .map(pr -> SenderRecord.create(pr, pr.key()));

        var sender = KafkaSender.create(senderOptions);
        sender.send(flux)
                .doOnNext(r -> log.info("correlation id: {}", r.correlationMetadata()))
                .doOnComplete(sender::close)
                .subscribe();
    }
}

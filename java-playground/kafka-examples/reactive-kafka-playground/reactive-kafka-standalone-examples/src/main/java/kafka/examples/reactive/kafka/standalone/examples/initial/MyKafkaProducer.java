package kafka.examples.reactive.kafka.standalone.examples.initial;

import java.time.Duration;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import reactor.core.publisher.Flux;
import reactor.kafka.sender.KafkaSender;
import reactor.kafka.sender.SenderOptions;
import reactor.kafka.sender.SenderRecord;

@Slf4j
public class MyKafkaProducer {
    public static void main(String[] args) {

        Map<String, Object> producerConfig = Map.<String, Object>of(
                ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092",
                ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class,
                ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class
        );
        var senderOptions = SenderOptions.<String, String>create(producerConfig);

        // To produce a 100 records
        var flux = Flux.interval(Duration.ofMillis(100))
                .take(100)
                .map(i -> new ProducerRecord<>("order-events", i.toString(), "order-" + i))
                                                               // map ProducerRecord to the reactor object - which is SenderRecord
                .map(pr -> SenderRecord.create(pr, pr.key()));

        var kafkaSender = KafkaSender.create(senderOptions);

        var start = System.currentTimeMillis();
        kafkaSender.send(flux)
                .doOnNext(r -> log.info("correlation id: {}", r.correlationMetadata())) // We are using key as the correlationMetadata
                /*.doOnComplete(kafkaSender::close)  // If we close the sender on completion, the program will terminate after sending.
                                                   // In real world, we don't do this unless there is a requirement for it.*/
                .doOnComplete(() -> {
                    log.info("Total time taken: {} ms", (System.currentTimeMillis() - start));
                    kafkaSender.close();
                })
                .subscribe();
    }
}

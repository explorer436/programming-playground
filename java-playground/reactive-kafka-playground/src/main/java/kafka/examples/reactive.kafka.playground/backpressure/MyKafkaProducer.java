package kafka.examples.reactive.kafka.playground.backpressure;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import reactor.core.publisher.Flux;
import reactor.kafka.sender.KafkaSender;
import reactor.kafka.sender.SenderOptions;
import reactor.kafka.sender.SenderRecord;

import java.util.Map;

@Slf4j
public class MyKafkaProducer {
    public static void main(String[] args) {

        Map<String, Object> producerConfig = Map.<String, Object>of(
                ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092",
                ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class,
                ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class
        );
        var senderOptions = SenderOptions.<String, String>create(producerConfig)
                .maxInFlight(10_000);
        // This is not the default value. Default is 256. The default value is small to handle backpressure well.
        // If we are sending a flux of a million records and the maxInFlight value is very low, due to backpressure, they will take a long time to be sent by the producer.
        // If we remove the maxInFligt value, we can see the difference. The producer will take much longer to send all those messages.

        // To produce a million records
        var flux = Flux.range(1, 1_000_000)
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

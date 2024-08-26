package kafka.examples.reactive.kafka.standalone.examples.messages_with_headers;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.internals.RecordHeaders;
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
        var senderOptions = SenderOptions.<String, String>create(producerConfig);

        var flux = Flux.range(1, 10).map(MyKafkaProducer::createSenderRecord);

        var kafkaSender = KafkaSender.create(senderOptions);

        var start = System.currentTimeMillis();
        kafkaSender.send(flux)
                .doOnNext(r -> log.info("correlation id: {}", r.correlationMetadata()))
                .doOnComplete(kafkaSender::close)
                .subscribe();
    }

    private static SenderRecord<String, String, String> createSenderRecord(Integer i){
        var headers = new RecordHeaders();
        headers.add("client-id", "some-client".getBytes());
        headers.add("tracing-id", "123".getBytes());
        var pr = new ProducerRecord<>("order-events", null, i.toString(), "order-"+i, headers);
        return SenderRecord.create(pr, pr.key());
    }
}

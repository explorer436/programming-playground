package com.my.company.cloud_stream_kafka_playground;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.EmbeddedKafkaBroker;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.kafka.test.utils.KafkaTestUtils;
import org.springframework.test.annotation.DirtiesContext;
import reactor.kafka.sender.KafkaSender;
import reactor.kafka.sender.SenderOptions;
import reactor.kafka.sender.SenderRecord;

import java.util.Map;
import java.util.function.UnaryOperator;

@DirtiesContext
@SpringBootTest(properties = {
		"spring.cloud.stream.kafka.binder.configuration.auto.offset.reset=earliest"
})
@EmbeddedKafka(
		// In order to preserve the order of the events.
		// If the order is not important, we don't have to set the number of partitions to 1.
		partitions = 1,
		// To be used by @EmbeddedKafka
		bootstrapServersProperty = "spring.kafka.bootstrap-servers"
)

public abstract class AbstractCloudStreamKafkaPlaygroundApplicationTests {

	@Autowired
	private EmbeddedKafkaBroker broker;

	protected <K, V> KafkaSender<K, V> createSender(UnaryOperator<SenderOptions<K, V>> builder){
		Map<String, Object> props = KafkaTestUtils.producerProps(broker);
		SenderOptions<K, V> options = SenderOptions.<K, V>create(props);
		options = builder.apply(options);
		return KafkaSender.create(options);
	}

	protected <K,V> SenderRecord<K, V, K> toSenderRecord(String topic, K key, V value){
		return SenderRecord.create(topic, null, null, key, value, key);
	}

}

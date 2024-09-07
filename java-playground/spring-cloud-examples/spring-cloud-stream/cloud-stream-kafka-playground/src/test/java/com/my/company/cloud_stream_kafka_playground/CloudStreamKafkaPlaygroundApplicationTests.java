package com.my.company.cloud_stream_kafka_playground;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.EmbeddedKafkaBroker;
import org.springframework.kafka.test.context.EmbeddedKafka;

@SpringBootTest
@EmbeddedKafka
class CloudStreamKafkaPlaygroundApplicationTests {

	@Autowired
	private EmbeddedKafkaBroker broker;

	@Test
	void contextLoads() {
	}

}

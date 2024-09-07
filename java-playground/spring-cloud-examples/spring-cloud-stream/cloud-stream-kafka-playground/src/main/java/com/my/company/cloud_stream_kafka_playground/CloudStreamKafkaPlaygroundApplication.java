package com.my.company.cloud_stream_kafka_playground;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.my.company.cloud_stream_kafka_playground.${sec}")
public class CloudStreamKafkaPlaygroundApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudStreamKafkaPlaygroundApplication.class, args);
	}

}

package com.example.springkafka.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.example.springkafka.model.Greeting;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProducerService {
	    
	private final KafkaTemplate<String, String> stringKafkaTemplate;
	
	private final KafkaTemplate<String, Greeting> greetingKafkaTemplate;
	
	@Value(value = "${kafka.message.topic.name}")
    private String messageTopicName;

    @Value(value = "${kafka.partitioned.topic.name}")
    private String partitionedTopicName;

    @Value(value = "${kafka.filtered.topic.name}")
    private String filteredTopicName;

    @Value(value = "${kafka.greeting.topic.name}")
    private String greetingTopicName;

	
	public ProducerService(KafkaTemplate<String, String> stringKafkaTemplate, KafkaTemplate<String, Greeting> greetingKafkaTemplate) {
	    this.stringKafkaTemplate = stringKafkaTemplate;
		this.greetingKafkaTemplate = greetingKafkaTemplate;
	}
	
	/**
	 * 
	 * The send() API returns a ListenableFuture object. 
	 * If we want to block the sending thread and get the result about the sent message, we can call the get API of the ListenableFuture object. 
	 * The thread will wait for the result, but it will slow down the producer.
	 * 
	 * Kafka is a fast stream processing platform. 
	 * Therefore, it's better to handle the results asynchronously so that the subsequent messages do not wait for the result of the previous message.
	 * We can do this through a callback.
	 * 
	 */
	public void sendMessage(String message) {
		log.info(String.format("$$$$ => Producing message: %s", message));
		
		ListenableFuture<SendResult<String, String>> future = this.stringKafkaTemplate.send(messageTopicName, message);
		future.addCallback(new ListenableFutureCallback<>() {
			@Override
			public void onFailure(Throwable ex) {
				log.info("Unable to send message=[ {} ] due to : {}", message, ex.getMessage());
			}
			
			@Override
			public void onSuccess(SendResult<String, String> sendResult) {
				log.info("Sent message=[ {} ] with offset=[ {} ]", message, sendResult.getRecordMetadata().offset());
				// log.info("sendResult.toString(): " + sendResult.toString());
			}
		});
		
		/**
		 * If you do not want to get the result, you can simply do this.kafkaTemplate.send(TOPIC, message);
		 */
	}
	
	public void sendGreeting(Greeting greeting) {
		log.info(String.format("$$$$ => Producing message: %s", greeting));
		
		ListenableFuture<SendResult<String, Greeting>> future = this.greetingKafkaTemplate.send(greetingTopicName, greeting);
		future.addCallback(new ListenableFutureCallback<>() {
			@Override
			public void onFailure(Throwable ex) {
				log.info("Unable to send message=[ {} ] due to : {}", greeting, ex.getMessage());
			}
			
			@Override
			public void onSuccess(SendResult<String, Greeting> sendResult) {
				log.info("Sent message=[ {} ] with offset=[ {} ]", greeting, sendResult.getRecordMetadata().offset());
				// log.info("sendResult.toString(): " + sendResult.toString());
			}
		});
	}
	
	public void sendMessageToPartition(String message, int partition) {
        this.stringKafkaTemplate.send(partitionedTopicName, partition, null, message);
    }

    public void sendMessageToFiltered(String message) {
    	this.stringKafkaTemplate.send(filteredTopicName, message);
    }
}

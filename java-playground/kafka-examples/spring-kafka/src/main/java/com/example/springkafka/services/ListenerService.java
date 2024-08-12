package com.example.springkafka.services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.example.springkafka.model.Greeting;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public final class ListenerService {

    /**
     * We can implement multiple listeners for a topic, each with a different group Id. 
     * Furthermore, one consumer can listen for messages from various topics:
     * @KafkaListener(topics = "topic1, topic2", groupId = "foo")
     */
    
    @KafkaListener(topics = "${kafka.message.topic.name}", groupId = "foo", containerFactory = "fooKafkaListenerContainerFactory")
    public void listenGroupFoo(String message) {
        log.info("Received Message in group 'foo': " + message);
    }

    @KafkaListener(topics = "${kafka.message.topic.name}", groupId = "bar", containerFactory = "barKafkaListenerContainerFactory")
    public void listenGroupBar(String message) {
        log.info("Received Message in group 'bar': " + message);
    }
    
    /**
     * Spring also supports retrieval of one or more message headers using the @Header annotation in the listener.
     */

    @KafkaListener(topics = "${kafka.message.topic.name}", containerFactory = "headersKafkaListenerContainerFactory")
    public void listenWithHeaders(@Payload String message, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        log.info("Received Message: " + message + " in headers listener from partition: " + partition);
    }
    
    /**
     * For a topic with multiple partitions, a @KafkaListener can explicitly subscribe to a particular partition of a topic with an initial offset.
     */
    
    /*@KafkaListener(
    		  topicPartitions = @TopicPartition(topic = "topicName",
    		  partitionOffsets = {
    		    @PartitionOffset(partition = "0", initialOffset = "0"), 
    		    @PartitionOffset(partition = "3", initialOffset = "0")}),
    		  containerFactory = "partitionsKafkaListenerContainerFactory")
    		public void listenToPartition(
    		  @Payload String message, 
    		  @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
    		      System.out.println(
    		        "Received Message: " + message"
    		        + " in partition listener from partition: " + partition);
    		}
    		
    		Since the initialOffset has been set to 0 in this listener, all the previously consumed messages from partitions 0 and 3 will be re-consumed every time this listener is initialized.
    		
    		*/

    /**
     * If we don't need to set the offset, we can use the partitions property of @TopicPartition annotation to set only the partitions without the offset.
     */
    @KafkaListener(topicPartitions = @TopicPartition(topic = "${kafka.partitioned.topic.name}", partitions = { "0", "3" }), containerFactory = "partitionsKafkaListenerContainerFactory")
    public void listenToPartition(@Payload String message, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        log.info("Received Message: " + message + " in partition listener from partition: " + partition);
    }
    
    /**
     * We can configure listeners to consume specific types of messages by adding a custom filter. 
     * This can be done by setting a RecordFilterStrategy to the KafkaListenerContainerFactory.
     * See filterKafkaListenerContainerFactory in MyCustomListenerConfig.java
     */

    @KafkaListener(topics = "${kafka.filtered.topic.name}", containerFactory = "filterKafkaListenerContainerFactory")
    public void listenWithFilter(String message) {
        log.info("Received Message in filtered listener: " + message);
    }
    
    @KafkaListener(topics = "${kafka.greeting.topic.name}", containerFactory = "greetingKafkaListenerContainerFactory")
    public void greetingListener(Greeting greeting) {
    	// log.info(String.format("$$$$ => Consumed greeting: %s", greeting.toString()));
    	log.info("Received greeting message in greeting listener: " + greeting.toString());
    }
}

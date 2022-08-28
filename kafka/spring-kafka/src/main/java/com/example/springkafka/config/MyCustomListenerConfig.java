package com.example.springkafka.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.example.springkafka.model.Greeting;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @EnableKafka annotation is required on the configuration class to enable detection of @KafkaListener annotation on spring-managed beans.
 * 
 * For consuming messages, we need to configure a ConsumerFactory and a KafkaListenerContainerFactory. 
 * Once these beans are available in the Spring bean factory, POJO-based consumers can be configured using @KafkaListener annotation.
 * See ConsumerService.java
 *
 */
@EnableKafka
@Configuration
public class MyCustomListenerConfig {
	
	@Value(value = "${kafka.bootstrapAddress}")
    private String bootstrapAddress;
    
    private Map<String, Object> getPropsForStringMessages(String groupId) {
		Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, 0);
        // props.put(ConsumerConfig.MAX_PARTITION_FETCH_BYTES_CONFIG, "20971520");
        // props.put(ConsumerConfig.FETCH_MAX_BYTES_CONFIG, "20971520");
		return props;
	}
    
    private Map<String, Object> getPropsForGreetingMessages(String groupId) {
    	
    	// final JsonDeserializer<Greeting> valueDeserializer = new JsonDeserializer<>();
    	// valueDeserializer.addTrustedPackages("com.example.springkafka.model");
    	  
		Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        props.put(JsonDeserializer.TRUSTED_PACKAGES, "com.example.springkafka.model");
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, 0);
        // props.put(ConsumerConfig.MAX_PARTITION_FETCH_BYTES_CONFIG, "20971520");
        // props.put(ConsumerConfig.FETCH_MAX_BYTES_CONFIG, "20971520");
		return props;
	}
    
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Greeting> greetingKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Greeting> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(new DefaultKafkaConsumerFactory<>(getPropsForGreetingMessages("greeting")));
        return factory;
    }
    
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> fooKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(new DefaultKafkaConsumerFactory<>(getPropsForStringMessages("foo")));
        return factory;
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> barKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(new DefaultKafkaConsumerFactory<>(getPropsForStringMessages("bar")));
        return factory;
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> headersKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(new DefaultKafkaConsumerFactory<>(getPropsForStringMessages("headers")));
        return factory;
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> partitionsKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(new DefaultKafkaConsumerFactory<>(getPropsForStringMessages("partitions")));
        return factory;
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> longMessageKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(new DefaultKafkaConsumerFactory<>(getPropsForStringMessages("longMessage")));
        return factory;
    }
    
    /**
     * In a listener using this container factory, all the messages matching the filter will be discarded.
     */
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> filterKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(new DefaultKafkaConsumerFactory<>(getPropsForStringMessages("filter")));
        factory.setRecordFilterStrategy(record -> record.value().contains("World"));
        return factory;
    }

}

package com.example.springkafka.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springkafka.model.Greeting;
import com.example.springkafka.services.ProducerService;

@RestController
@RequestMapping("/kafka")
public final class KafkaController {
	
    private final ProducerService producerService;

    public KafkaController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping(value = "/publishMessage")
    public void sendMessageToKafkaTopic(@RequestParam String message) {
        producerService.sendMessage(message);
    }
    
    @PostMapping(value = "/publishGreeting")
    public void sendMessageToKafkaTopic() {
    	Greeting greeting = new Greeting();
    	greeting.setName("explorer");
    	greeting.setMsg("Hello");
    	
        producerService.sendGreeting(greeting);
    }
    
    @PostMapping(value = "/publishToPartition")
    public void sendMessageToPartition() {
    	// Make sure that there are available partitions on the topic before running this.
        for (int i = 0; i < 3; i++) {
        	producerService.sendMessageToPartition("Hello To Partitioned Topic!", i);
        }
    }
    
    @PostMapping(value = "/publishToFiltered")
    public void sendMessageToFiltered() {
        producerService.sendMessageToFiltered("Hello Baeldung!");
        producerService.sendMessageToFiltered("Hello World!");
    }
}

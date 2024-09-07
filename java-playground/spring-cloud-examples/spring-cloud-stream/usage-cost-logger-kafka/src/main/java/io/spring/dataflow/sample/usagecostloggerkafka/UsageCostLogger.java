package io.spring.dataflow.sample.usagecostloggerkafka;

import java.util.function.Consumer;
import org.springframework.context.annotation.Bean;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UsageCostLogger {
	
	/**
	 * Configuring the UsageCostLogger Application:
       When configuring the consumer application, we need to set the input binding destination (a Kafka topic). 
	   By default, the input binding used by Spring Cloud Stream will be process-in-0 (so does the destination name if the application does not override it). 
	   We want to override these to make the sink application work with the above two applications (source and processor).

       See application.properties
	 */
    @Bean
	public Consumer<UsageCostDetail> logger() {
		return usageCostDetail -> {
			log.info("usageCostDetail.toString : " + usageCostDetail.toString());
		};
	}	

}

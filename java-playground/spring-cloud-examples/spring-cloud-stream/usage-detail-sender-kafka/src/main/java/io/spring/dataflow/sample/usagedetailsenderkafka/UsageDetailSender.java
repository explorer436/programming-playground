package io.spring.dataflow.sample.usagedetailsenderkafka;

import java.util.Random;
import java.util.function.Supplier;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsageDetailSender {

  private String[] users = {"user1", "user2", "user3", "user4", "user5"};

  /**
   * Configuring the UsageDetailSender application:
   * When configuring the producer application, we need to set the producer binding destination (Kafka topic) where the producer publishes the data. 
   * The default producer output binding for the above method is going to be sendEvents-out-0 
   * (method name followed by the literal -out-0 where 0 is the index). 
   * If the application does not set a destination, Spring Cloud Stream will use this same binding name as the output destination (Kafka topic). 
   * However, in our case, we neither want this default binding name used by Spring Cloud Stream nor the destination name. 
   * We want to use the binding name as output and provide a custom destination. 
   * 
   * See application.properties
   */
  @Bean
	public Supplier<UsageDetail> sendEvents() {
		return () -> {
			UsageDetail usageDetail = new UsageDetail();
			usageDetail.setUserId(this.users[new Random().nextInt(5)]);
			usageDetail.setDuration(new Random().nextInt(300));
			usageDetail.setData(new Random().nextInt(700));
			return usageDetail;
		};
	}
}

package io.spring.dataflow.sample.usagecostprocessorkafka;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * We are providing a bean that returns a java.util.function.Function that consumes a UsageDetail as input and publishes a UsageCostDetail as ouptut.
 * 
 * Configuring the UsageCostProcessor Application:
   When configuring this processor application, we need to set both the input and output destinations (Kafka topics). 
   By default, Sprig Cloud Stream uses binding names as processUsageCost-in-0 and processUsageCost-out-0 which becomes the topic names unless the application overrides them. 
   However, we don't want these defaults but rather we would want to make them more descriptive. 
   We want to use the binding name as input and output and provide custom destinations on them.

   See application.properties
 *
 */
@Configuration
public class UsageCostProcessor {

	private double ratePerSecond = 0.1;

	private double ratePerMB = 0.05;

	@Bean
	public Function<UsageDetail, UsageCostDetail> processUsageCost() {
		System.out.println(">>> processUsageCost()");
		return usageDetail -> {
			UsageCostDetail usageCostDetail = new UsageCostDetail();
			usageCostDetail.setUserId(usageDetail.getUserId());
			usageCostDetail.setCallCost(usageDetail.getDuration() * this.ratePerSecond);
			usageCostDetail.setDataCost(usageDetail.getData() * this.ratePerMB);
			return usageCostDetail;
		};
	}
}

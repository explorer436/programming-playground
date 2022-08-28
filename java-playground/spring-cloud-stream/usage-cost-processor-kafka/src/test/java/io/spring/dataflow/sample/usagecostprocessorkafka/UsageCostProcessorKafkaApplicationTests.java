package io.spring.dataflow.sample.usagecostprocessorkafka;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.stream.binder.test.InputDestination;
import org.springframework.cloud.stream.binder.test.OutputDestination;
import org.springframework.cloud.stream.binder.test.TestChannelBinderConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.converter.CompositeMessageConverter;
import org.springframework.messaging.converter.MessageConverter;


@SpringBootTest
class UsageCostProcessorKafkaApplicationTests {

	@Test
	void contextLoads() {
	}

	/**
	 * Prerequisite:
	 * 
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-stream</artifactId>
			<scope>test</scope>
			<classifier>test-binder</classifier>
			<type>test-jar</type>
		</dependency>

        The testUsageCostProcessor test case uses the test binder's InputDestination to publish a message which is consumed by the function in the processor. 
		Then we use the OutputDestination to verify that the UsageDetail is property transformed into a UsageCostDetail.
	 */
    @Test
	public void testUsageCostProcessor() {
		try (ConfigurableApplicationContext context = new SpringApplicationBuilder(
				TestChannelBinderConfiguration.getCompleteConfiguration(
						UsageCostProcessorKafkaApplication.class)).web(WebApplicationType.NONE)
				.run()) {

			InputDestination source = context.getBean(InputDestination.class);

			UsageDetail usageDetail = new UsageDetail();
			usageDetail.setUserId("user1");
			usageDetail.setDuration(30);
			usageDetail.setData(100);

			final MessageConverter converter = context.getBean(CompositeMessageConverter.class);
			Map<String, Object> headers = new HashMap<>();
			headers.put("contentType", "application/json");
			MessageHeaders messageHeaders = new MessageHeaders(headers);
			final Message<?> message = converter.toMessage(usageDetail, messageHeaders);

			source.send(message);

			OutputDestination target = context.getBean(OutputDestination.class);
			Message<byte[]> sourceMessage = target.receive(10000);

			final UsageCostDetail usageCostDetail = (UsageCostDetail) converter
					.fromMessage(sourceMessage, UsageCostDetail.class);

			assertEquals(usageCostDetail.getCallCost(), 3.0);
			assertEquals(usageCostDetail.getDataCost(), 5);
		}
    }

}

package io.spring.dataflow.sample.usagedetailsenderkafka;

import org.junit.jupiter.api.Test;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.binder.test.OutputDestination;
import org.springframework.cloud.stream.binder.test.TestChannelBinderConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.messaging.Message;
import org.springframework.messaging.converter.CompositeMessageConverter;
import org.springframework.messaging.converter.MessageConverter;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UsageDetailSenderKafkaApplicationTests {

	/**
	 * The contextLoads test case verifies the application starts successfully.
	 */
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
		
		Instead of the Kafka binder, the tests use the Test binder to trace and test your application's outbound and inbound messages. 
		The Test binder provides abstractions for output and input destinations as OutputDestination and InputDestination. 
		Using them, you can simulate the behavior of actual middleware based binders.
		
	    The testUsageDetailSender test case uses the test binder to receive messages from the output destination where the supplier publishes messages to.	
	 */
    @Test
	public void testUsageDetailSender() {
		try (ConfigurableApplicationContext context = new SpringApplicationBuilder(
				TestChannelBinderConfiguration
						.getCompleteConfiguration(UsageDetailSenderKafkaApplication.class))
				.web(WebApplicationType.NONE)
				.run()) {

			OutputDestination target = context.getBean(OutputDestination.class);
			Message<byte[]> sourceMessage = target.receive(10000);

			final MessageConverter converter = context.getBean(CompositeMessageConverter.class);
			UsageDetail usageDetail = (UsageDetail) converter
					.fromMessage(sourceMessage, UsageDetail.class);

			assertThat(usageDetail.getUserId()).isBetween("user1", "user5");
			assertThat(usageDetail.getData()).isBetween(0, 700);
			assertThat(usageDetail.getDuration()).isBetween(0, 300);
		}
	}	

}

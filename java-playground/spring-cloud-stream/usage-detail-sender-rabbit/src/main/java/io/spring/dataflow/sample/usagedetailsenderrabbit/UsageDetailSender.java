package io.spring.dataflow.sample.usagedetailsenderrabbit;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * The @EnableBinding annotation indicates that you want to bind your application to messaging middleware. 
 * The annotation takes one or more interfaces as a parameter — in this case, the Source interface that defines an output channel named output. 
 * In the case of RabbitMQ, messages sent to the output channel are in turn sent to the RabbitMQ message broker by using a TopicExchange.
 * 
 * The @EnableScheduling annotation indicates that you want to enable Spring's scheduling capabilities, which invokes methods annotated with @Scheduled with the specified fixedDelay of 1 second.
 * 
 * The sendEvents method constructs a UsageDetail object and then sends it to the the output channel by accessing the Source object's output().send() method.
 */
@EnableScheduling
@EnableBinding(Source.class)
public class UsageDetailSender {

  @Autowired
  private Source source;

  private String[] users = {"user1", "user2", "user3", "user4", "user5"};

  @Scheduled(fixedDelay = 1000)
  public void sendEvents() {
    UsageDetail usageDetail = new UsageDetail();

    usageDetail.setUserId(this.users[new Random().nextInt(5)]);
    usageDetail.setDuration(new Random().nextInt(300));
    usageDetail.setData(new Random().nextInt(700));

    this.source.output().send(MessageBuilder.withPayload(usageDetail).build());
  }
}

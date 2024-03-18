package com.mycompany.camelmicroservicea.routes.a;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

// @Component
public class ActiveMQMessageSenderRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        // timer
        // put messages on the queue

        // 10 seconds
        from("timer:active-mq-timer?period=10000")
                .transform().constant("My message for Active MQ")
                .log("${body}")
                .to("activemq:my-activemq-queue");
    }
}

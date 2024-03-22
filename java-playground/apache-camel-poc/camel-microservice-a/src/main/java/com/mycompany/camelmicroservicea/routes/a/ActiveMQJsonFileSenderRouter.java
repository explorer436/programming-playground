package com.mycompany.camelmicroservicea.routes.a;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ActiveMQJsonFileSenderRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        // timer
        // put messages on the queue

        // 10 seconds
        from("file:/home/explorer436/Downloads/GitRepositories/programming-playground/java-playground/apache-camel-poc/camel-microservice-a/input-folder/json")
                .log("${body}")
                .to("activemq:my-activemq-json-queue");
    }
}

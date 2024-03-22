package com.mycompany.camelmicroservicea.routes.a;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

// @Component
public class ChoiceRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:/home/explorer436/Downloads/GitRepositories/programming-playground/java-playground/apache-camel-poc/camel-microservice-a/input-folder")
                .routeId("Choice-Route")
                .choice()
                    .when(simple("${file:ext} ends with 'xml'"))
                        .log("Xml file")
                    .otherwise()
                        .log("Not an Xml file")
                .end()
                .log("${body}")  // logs the body (content) of the file
                .to("file:/home/explorer436/Downloads/GitRepositories/programming-playground/java-playground/apache-camel-poc/camel-microservice-a/output-folder");
    }
}

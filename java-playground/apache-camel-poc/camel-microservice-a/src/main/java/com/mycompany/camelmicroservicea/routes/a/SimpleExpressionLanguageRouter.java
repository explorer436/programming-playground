package com.mycompany.camelmicroservicea.routes.a;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

// @Component
public class SimpleExpressionLanguageRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:/home/explorer436/Downloads/GitRepositories/programming-playground/java-playground/apache-camel-poc/camel-microservice-a/input-folder")
                .routeId("Choice-Route")
                .transform().body(String.class)
                .choice()
                    .when(simple("${file:ext} ends with 'xml'"))
                        .log("Xml file")
                    .when(simple("${body} contains 'USD'"))
                        .log("Not an Xml file BUT contains USD")
                    .otherwise()
                        .log("Not an Xml file")
                .end()
                .log("${body}")  // logs the body (content) of the file
                .log("${messageHistory}")
                .to("file:/home/explorer436/Downloads/GitRepositories/programming-playground/java-playground/apache-camel-poc/camel-microservice-a/output-folder");
    }
}

package com.mycompany.camelmicroservicea.routes.a;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Body;
import org.apache.camel.Headers;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class ComplexChoiceRouter extends RouteBuilder {

    private final DeciderBean deciderBean;

    @Override
    public void configure() throws Exception {
        from("file:/home/explorer436/Downloads/GitRepositories/programming-playground/java-playground/apache-camel-poc/camel-microservice-a/input-folder")
                .routeId("Choice-Route")
                .transform().body(String.class)
                .choice()
                .when(simple("${file:ext} ends with 'xml'"))
                .log("Xml file")
                .when(method(deciderBean))
                .log("Not an Xml file BUT contains USD")
                .otherwise()
                .log("Not an Xml file")
                .end()
                .log("${body}")  // logs the body (content) of the file
                .to("file:/home/explorer436/Downloads/GitRepositories/programming-playground/java-playground/apache-camel-poc/camel-microservice-a/output-folder");
    }
}

@Component
@Slf4j
class DeciderBean {
    public boolean isThisConditionMet(@Body String body, @Headers Map<String, String> headers) {

        // We can use all the properties on Exchange if it is passed as a parameter to this method.

        log.info("DeciderBean - {}, {}", body, headers);
        return true;
    }
}
package com.mycompany.camelmicroservicea.routes.a;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

// @Component
public class MyFileMoverRouter extends RouteBuilder {

    // Moving files from one endpoint to another endpoint

    private static final String SOURCE_FOLDER =  "src/main/resources/source-folder";
    private static final String DESTINATION_FOLDER = "src/main/resources/destination-folder";

    @Override
    public void configure() throws Exception {
        from("file:/home/explorer436/Downloads/GitRepositories/programming-playground/java-playground/apache-camel-poc/camel-microservice-a/input-folder")
                // .log("${body}")  // logs the body (content) of the file
                .to("file:/home/explorer436/Downloads/GitRepositories/programming-playground/java-playground/apache-camel-poc/camel-microservice-a/output-folder");

        // This did not work for me.
        /*from("file:input-folder")
                // .log("${body}")  // logs the body (content) of the file
                .to("file:output-folder");*/

        // This did not work for me.
        /*from("file://" + SOURCE_FOLDER + "?delete=true")
                .to("file://" + DESTINATION_FOLDER);*/
    }
}

package com.mycompany.camelmicroserviceb.routes.b;

import com.mycompany.camelmicroserviceb.model.CurrencyExchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

@Component
public class ActiveMqReceiverRouter extends RouteBuilder {

    // Recieve a json and unmarshall it

    @Override
    public void configure() throws Exception {
    from("activemq:my-activemq-queue")
            .log("${body}")
            .unmarshal().json(JsonLibrary.Jackson, CurrencyExchange.class)
            .log("${body}")
            .to("log:received-message-from-activemq");
    }
}

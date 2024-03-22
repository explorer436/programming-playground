package com.mycompany.camelmicroserviceb.routes.b;

import com.mycompany.camelmicroserviceb.model.CurrencyExchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

@Component
public class ActiveMqXmlReceiverRouter extends RouteBuilder {

    // Recieve a json and unmarshall it
    // We can use beans and processors to do further processing on the POJOs after unmarshalling them

    @Override
    public void configure() throws Exception {
    from("activemq:my-activemq-xml-queue")
            .log("${body}")
            .unmarshal()
            .jacksonXml(CurrencyExchange.class)
            .log("${body}")
            .to("log:received-message-from-activemq");
    }
}

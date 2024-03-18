package com.mycompany.camelmicroservicea.routes.a;

import com.mycompany.camelmicroservicea.beans.GetCurrentTimeBean;
import com.mycompany.camelmicroservicea.beans.SimpleLoggingBean;
import com.mycompany.camelmicroservicea.processors.SimpleLoggingProcessor;
import lombok.RequiredArgsConstructor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

// @Component
@RequiredArgsConstructor
public class MyFourthTimerRouter extends RouteBuilder {

    private final GetCurrentTimeBean getCurrentTimeBean;

    private final SimpleLoggingProcessor simpleLoggingProcessor;

    // Using a processor for logging

    @Override
    public void configure() throws Exception {
        from("timer:fourth-timer")
                .bean(simpleLoggingProcessor, "process")
                .transform().constant("My Constant Message")
                .bean(simpleLoggingProcessor, "process")
                .bean(getCurrentTimeBean, "getCurrentTime") // use method name in addition to bean name
                .bean(simpleLoggingProcessor, "process")
                .log("${body}")   // This will print the same thing as the line above.
                .to("log:fourth-timer");

        // 2024-03-13T18:59:05.907-04:00  INFO 488333 --- [camel-microservice-a] [://fourth-timer] c.m.c.processors.SimpleLoggingProcessor  : SimpleLoggingProcessor :: msg is : null
        // 2024-03-13T18:59:05.908-04:00  INFO 488333 --- [camel-microservice-a] [://fourth-timer] c.m.c.processors.SimpleLoggingProcessor  : SimpleLoggingProcessor :: msg is : My Constant Message
        // 2024-03-13T18:59:05.909-04:00  INFO 488333 --- [camel-microservice-a] [://fourth-timer] c.m.c.processors.SimpleLoggingProcessor  : SimpleLoggingProcessor :: msg is : Time now is : 2024-03-13T18:59:05.908725622
        // 2024-03-13T18:59:05.909-04:00  INFO 488333 --- [camel-microservice-a] [://fourth-timer] route1                                   : Time now is : 2024-03-13T18:59:05.908725622
        // 2024-03-13T18:59:05.909-04:00  INFO 488333 --- [camel-microservice-a] [://fourth-timer] fourth-timer                             : Exchange[ExchangePattern: InOnly, BodyType: String, Body: Time now is : 2024-03-13T18:59:05.908725622]
    }
}

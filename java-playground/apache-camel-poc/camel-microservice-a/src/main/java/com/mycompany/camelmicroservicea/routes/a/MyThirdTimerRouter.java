package com.mycompany.camelmicroservicea.routes.a;

import com.mycompany.camelmicroservicea.beans.GetCurrentTimeBean;
import com.mycompany.camelmicroservicea.beans.SimpleLoggingBean;
import lombok.RequiredArgsConstructor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

// @Component
@RequiredArgsConstructor
public class MyThirdTimerRouter extends RouteBuilder {

    private final GetCurrentTimeBean getCurrentTimeBean;

    private final SimpleLoggingBean simpleLoggingBean;

    // Using a bean for logging

    @Override
    public void configure() throws Exception {
        from("timer:third-timer")
                .bean(simpleLoggingBean, "process")
                .transform().constant("My Constant Message")
                .bean(simpleLoggingBean, "process")
                .bean(getCurrentTimeBean, "getCurrentTime") // use method name in addition to bean name
                .bean(simpleLoggingBean, "process")
                .log("${body}")   // This will print the same thing as the line above.
                .to("log:third-timer");

        // 2024-03-13T18:37:54.302-04:00  INFO 449316 --- [camel-microservice-a] [r://third-timer] c.m.c.beans.SimpleLoggingBean : SimpleLoggingBean :: msg is : null
        // 2024-03-13T18:37:54.303-04:00  INFO 449316 --- [camel-microservice-a] [r://third-timer] c.m.c.beans.SimpleLoggingBean : SimpleLoggingBean :: msg is : My Constant Message
        // 2024-03-13T18:37:54.304-04:00  INFO 449316 --- [camel-microservice-a] [r://third-timer] c.m.c.beans.SimpleLoggingBean : SimpleLoggingBean :: msg is : Time now is : 2024-03-13T18:37:54.303916032
        // 2024-03-13T18:37:54.304-04:00  INFO 449316 --- [camel-microservice-a] [r://third-timer] route1                        : Time now is : 2024-03-13T18:37:54.303916032
        // 2024-03-13T18:37:54.305-04:00  INFO 449316 --- [camel-microservice-a] [r://third-timer] third-timer                   : Exchange[ExchangePattern: InOnly, BodyType: String, Body: Time now is : 2024-03-13T18:37:54.303916032]
    }
}

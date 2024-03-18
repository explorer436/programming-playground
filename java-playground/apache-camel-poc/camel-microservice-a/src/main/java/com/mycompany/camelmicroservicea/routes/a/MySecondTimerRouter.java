package com.mycompany.camelmicroservicea.routes.a;

import com.mycompany.camelmicroservicea.beans.GetCurrentTimeBean;
import lombok.RequiredArgsConstructor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

// Component
@RequiredArgsConstructor
public class MySecondTimerRouter extends RouteBuilder {

    private final GetCurrentTimeBean getCurrentTimeBean;

    @Override
    public void configure() throws Exception {
        from("timer:second-timer")
                .log("${body}")
                .transform().constant("My Constant Message")
                .log("${body}")
                .bean(getCurrentTimeBean, "getCurrentTime") // use method name in addition to bean name
                .log("${body}")
                .to("log:second-timer");

        // Processing vs Transformation

        // This will print the following.
        // The reason is, the body is transformed after each step.

        // 2024-03-13T18:24:31.683-04:00  INFO 428252 --- [camel-microservice-a] [://second-timer] route2 : null
        // 2024-03-13T18:24:31.683-04:00  INFO 428252 --- [camel-microservice-a] [://second-timer] route2 : My Constant Message
        // 2024-03-13T18:24:31.684-04:00  INFO 428252 --- [camel-microservice-a] [://second-timer] route2 : Time now is : 2024-03-13T18:24:31.684346168
    }
}

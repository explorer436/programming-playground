package com.mycompany.camelmicroservicea.routes.a;

import com.mycompany.camelmicroservicea.beans.GetCurrentTimeBean;
import lombok.RequiredArgsConstructor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

// @Component
@RequiredArgsConstructor
public class MyFirstTimerRouter extends RouteBuilder {

    private final GetCurrentTimeBean getCurrentTimeBean;

    @Override
    public void configure() throws Exception {

        // Route # 1
        // listen to a queue
        // do some transformation on that message
        // save to database

        //---------------
        // Route # 2
        // use a timer
        // write a message to the logs

        // from("timer:first-timer")
        //         .to("log:first-timer");

        // By looking at the logs, we notice that this happens every one second:
        // 2024-03-13T12:40:19.560-04:00  INFO 4094945 --- [camel-microservice-a] [r://first-timer] first-timer : Exchange[ExchangePattern: InOnly, BodyType: null, Body: [Body is null]]
        //---------------
        // Route # 2
        // use a timer
        // write a message to the logs

        // from("timer:first-timer")
        //         .transform().constant("My Constant Message")
        //         .to("log:first-timer");

        // After we add the "transform(),
        // 2024-03-13T12:42:52.650-04:00  INFO 4099534 --- [camel-microservice-a] [r://first-timer] first-timer : Exchange[ExchangePattern: InOnly, BodyType: String, Body: My Constant Message]
        //---------------
        // Route # 2
        // use a timer
        // write a message to the logs
        // from("timer:first-timer")
        //         .transform().constant("Time now is " + LocalDateTime.now())
        //         .to("log:first-timer");

        // Notice that it prints the same timestamp all the time.
        // 2024-03-13T12:44:05.598-04:00  INFO 4101411 --- [camel-microservice-a] [r://first-timer] first-timer : Exchange[ExchangePattern: InOnly, BodyType: String, Body: Time now is 2024-03-13T12:43:58.432828392]
        // 2024-03-13T12:44:06.598-04:00  INFO 4101411 --- [camel-microservice-a] [r://first-timer] first-timer : Exchange[ExchangePattern: InOnly, BodyType: String, Body: Time now is 2024-03-13T12:43:58.432828392]
        //---------------
        // Route # 2
        // use a timer
        // write a message to the logs
        // from("timer:first-timer")
        //         .bean(getCurrentTimeBean)
        //         .to("log:first-timer");

        // Now, it prints varying timestamp
        // 2024-03-13T18:09:59.575-04:00  INFO 404889 --- [camel-microservice-a] [r://first-timer] first-timer : Exchange[ExchangePattern: InOnly, BodyType: String, Body: Time now is : 2024-03-13T18:09:59.575044492]
        //2024-03-13T18:10:00.575-04:00  INFO 404889 --- [camel-microservice-a] [r://first-timer] first-timer : Exchange[ExchangePattern: InOnly, BodyType: String, Body: Time now is : 2024-03-13T18:10:00.574662065]
        //---------------
        // Route # 2
        // use a timer
        // write a message to the logs
        from("timer:first-timer")
	    .bean(getCurrentTimeBean, "getCurrentTime") // use method name in addition to bean name
                .to("log:first-timer");

        // Now, it prints varying timestamp
        // 2024-03-13T18:09:59.575-04:00  INFO 404889 --- [camel-microservice-a] [r://first-timer] first-timer : Exchange[ExchangePattern: InOnly, BodyType: String, Body: Time now is : 2024-03-13T18:09:59.575044492]
        //2024-03-13T18:10:00.575-04:00  INFO 404889 --- [camel-microservice-a] [r://first-timer] first-timer : Exchange[ExchangePattern: InOnly, BodyType: String, Body: Time now is : 2024-03-13T18:10:00.574662065]
        //---------------
    }
}

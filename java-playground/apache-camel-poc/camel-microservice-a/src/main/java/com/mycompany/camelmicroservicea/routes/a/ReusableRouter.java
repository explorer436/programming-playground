package com.mycompany.camelmicroservicea.routes.a;

import com.mycompany.camelmicroservicea.beans.GetCurrentTimeBean;
import lombok.RequiredArgsConstructor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReusableRouter extends RouteBuilder {

    private final GetCurrentTimeBean getCurrentTimeBean;

    @Override
    public void configure() throws Exception {

        from("timer:first-timer")
	    .bean(getCurrentTimeBean, "getCurrentTime") // use method name in addition to bean name
                .to("direct:log-values");

        // A re-usable route that can be used across camel context
        from("direct:log-values")
                .routeId("Log-Values-Route")
                .log("${body}");
    }
}

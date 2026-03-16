package org.acme;

import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.metrics.LongCounter;
import io.opentelemetry.api.metrics.Meter;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.instrumentation.annotations.WithSpan;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jboss.logging.Logger;

@Path("/hello")
public class HelloResource {

    private static final Logger LOG = Logger.getLogger(HelloResource.class);

    private final Tracer tracer;
    private final LongCounter helloCounter;

    public HelloResource(OpenTelemetry openTelemetry) {
        this.tracer = openTelemetry.getTracer("service-b");
        Meter meter = openTelemetry.getMeter("service-b");
        this.helloCounter = meter.counterBuilder("hello_requests_total")
                .setDescription("Total number of hello requests")
                .build();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        LOG.info("Received request for /hello in Service B");
        helloCounter.add(1);
        
        Span span = Span.current();
        span.setAttribute("custom.business.attribute", "service-b-processed");

        return performInternalWork();
    }

    @WithSpan(value = "internal_work_b")
    public String performInternalWork() {
        LOG.info("Performing internal work in Service B");
        return "Hello from Service B!";
    }
}

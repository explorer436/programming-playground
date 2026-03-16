package org.acme;

import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.metrics.LongCounter;
import io.opentelemetry.api.metrics.Meter;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.instrumentation.annotations.WithSpan;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jboss.logging.Logger;

@Path("/invoke")
public class InvokeResource {

    private static final Logger LOG = Logger.getLogger(InvokeResource.class);

    private final Tracer tracer;
    private final LongCounter invokeCounter;

    @RestClient
    ServiceBClient serviceBClient;

    public InvokeResource(OpenTelemetry openTelemetry) {
        this.tracer = openTelemetry.getTracer("service-a");
        Meter meter = openTelemetry.getMeter("service-a");
        this.invokeCounter = meter.counterBuilder("invoke_requests_total")
                .setDescription("Total number of invoke requests")
                .build();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String invoke() {
        LOG.info("Received request for /invoke in Service A");
        invokeCounter.add(1);

        Span span = Span.current();
        span.setAttribute("custom.caller.attribute", "service-a-caller");

        String response = performInternalWorkAndCallServiceB();
        return "Service A says: " + response;
    }

    @WithSpan(value = "internal_work_a")
    public String performInternalWorkAndCallServiceB() {
        LOG.info("Calling Service B from Service A");
        return serviceBClient.getHello();
    }
}

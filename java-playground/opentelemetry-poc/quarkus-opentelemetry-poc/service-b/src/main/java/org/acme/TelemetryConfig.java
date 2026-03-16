package org.acme;

import io.opentelemetry.exporter.logging.LoggingMetricExporter;
import io.opentelemetry.exporter.logging.LoggingSpanExporter;
import io.opentelemetry.sdk.metrics.export.MetricExporter;
import io.opentelemetry.sdk.trace.export.SpanExporter;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

@ApplicationScoped
public class TelemetryConfig {

    @Produces
    @ApplicationScoped
    public SpanExporter spanExporter() {
        return LoggingSpanExporter.create();
    }

    @Produces
    @ApplicationScoped
    public MetricExporter metricExporter() {
        return LoggingMetricExporter.create();
    }
}

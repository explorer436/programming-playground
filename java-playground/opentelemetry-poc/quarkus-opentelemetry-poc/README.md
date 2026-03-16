# Quarkus OpenTelemetry Proof of Concept (POC)

This POC demonstrates how OpenTelemetry (OTel) works in a distributed Java environment using Quarkus. It covers Traces, Metrics, and Logs using a hybrid instrumentation approach (Auto + Manual).

## Architecture

- **Service A (Frontend):** 
  - Runs on port `8080`.
  - Exposes `/invoke` endpoint.
  - Calls Service B using a Quarkus REST Client.
- **Service B (Backend):**
  - Runs on port `8081`.
  - Exposes `/hello` endpoint.

## Key Features

- **Hybrid Instrumentation:** Uses `quarkus-opentelemetry` for automatic instrumentation of JAX-RS and REST Clients, plus manual instrumentation using the OTel SDK (`@WithSpan`, `setAttribute`).
- **Distributed Tracing:** Shows how `Trace ID` propagates across service boundaries automatically.
- **Metrics:** Demonstrates manual counters using the OTel `Meter` API.
- **Console Export:** Telemetry data (Traces/Metrics) is exported directly to the standard output (Console) using `LoggingSpanExporter` and `LoggingMetricExporter`.

## Getting Started

1. **Clone/Navigate to the project:**
   ```bash
   cd /home/developer/workspace/quarkus-opentelemetry-poc
   ```

2. **Run Service B (Backend):**
   Open a terminal and run:
   ```bash
   cd service-b
   ./mvnw quarkus:dev
   ```

3. **Run Service A (Frontend):**
   Open another terminal and run:
   ```bash
   cd service-a
   ./mvnw quarkus:dev
   ```

4. **Trigger a Request:**
   In a third terminal, call the Service A endpoint:
   ```bash
   curl http://localhost:8080/invoke
   ```

## Observing Results

- **Traces:** Look at the logs of both services. You will see lines from `LoggingSpanExporter` showing spans with the **same Trace ID** across both services.
- **Metrics:** Periodically, the console will print aggregated metric data, including `hello_requests_total` and `invoke_requests_total`.
- **Logs:** Standard JBoss logs will show the trace context if configured in the log pattern.

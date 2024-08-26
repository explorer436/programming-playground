package kafka.examples.reactive.kafka.standalone.examples.withspring.model;

public record DummyOrder(
        String orderId,
        String customerId
) {}

package kafka.examples.reactive.kafka.playground.withspring.model;

public record DummyOrder(
        String orderId,
        String customerId
) {}

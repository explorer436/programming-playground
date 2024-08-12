package kafka.examples.reactive.kafka.playground.withspring.model;

import java.time.LocalDateTime;
import java.util.UUID;

public record OrderEvent(
        UUID orderId,
        long customerId,
        LocalDateTime orderDate
) {}

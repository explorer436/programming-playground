package kafka.examples.reactive.kafka.standalone.examples.withspring.model;

import java.time.LocalDateTime;
import java.util.UUID;

public record OrderEvent(
        UUID orderId,
        long customerId,
        LocalDateTime orderDate
) {}

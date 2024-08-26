package kafka.examples.reactive.kafka.standalone.examples.transactions;

public record TransferEvent(
        String key,
        String from,
        String to,
        String amount,
        Runnable acknowledge
) {
}

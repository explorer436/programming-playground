package kafka.examples.reactive.kafka.playground.transactions;

public record TransferEvent(
        String key,
        String from,
        String to,
        String amount,
        Runnable acknowledge
) {
}

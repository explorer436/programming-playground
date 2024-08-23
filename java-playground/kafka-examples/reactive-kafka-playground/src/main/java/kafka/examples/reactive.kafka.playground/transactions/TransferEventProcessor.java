package kafka.examples.reactive.kafka.playground.transactions;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.kafka.sender.KafkaSender;
import reactor.kafka.sender.SenderRecord;
import reactor.kafka.sender.SenderResult;
import reactor.kafka.sender.TransactionManager;

import java.time.Duration;
import java.util.function.Predicate;

@Slf4j
public class TransferEventProcessor {

    private final KafkaSender<String, String> sender;

    public TransferEventProcessor(KafkaSender<String, String> sender) {
        this.sender = sender;
    }

    public Flux<SenderResult<String>> process(Flux<TransferEvent> flux){
        return flux
                .concatMap(this::validate)
                .concatMap(this::sendTransaction);
    }

    // To simulate a validation error - The account "5" does not have money to transfer.
    private Mono<TransferEvent> validate(TransferEvent event){
        return Mono.just(event)
                .filter(Predicate.not(e -> e.key().equals("5")))
                .switchIfEmpty(
                        Mono.<TransferEvent>fromRunnable(event.acknowledge())
                                .doFirst(() -> log.info("fails validation: {}", event.key()))
                );
    }

    private Mono<SenderResult<String>> sendTransaction(TransferEvent event){
        Flux<SenderRecord<String, String, String>> senderRecords = toSenderRecords(event);
        TransactionManager manager = sender.transactionManager();

        return manager
                .begin()
                .then(
                        // What does last() mean here?
                        // If multiple consumers are reading from the topic to which this is writing, all of them will emit acknowledgements.
                        // We don't want to read all of them - we can if we want to. That is an alternate approach.
                        // We are only interested in the last emitted event.
                        this.sender.send(senderRecords)
                        // delaying for demo
                        .concatWith(Mono.delay(Duration.ofSeconds(1)).then(Mono.fromRunnable(event.acknowledge())))
                        .concatWith(manager.commit())
                        .last())
                .doOnError(ex -> log.error(ex.getMessage()))
                .onErrorResume(ex -> manager.abort());
    }

    private Flux<SenderRecord<String, String, String>> toSenderRecords(TransferEvent event){

        // Two events
        // The first one to indicate credit from the first account
        // The second one to indicate debit to the second account

        ProducerRecord<String, String> pr1 = new ProducerRecord<>("transaction-events", event.key(), "%s+%s".formatted(event.to(), event.amount()));
        ProducerRecord<String, String> pr2 = new ProducerRecord<>("transaction-events", event.key(), "%s-%s".formatted(event.from(), event.amount()));
         
        SenderRecord<String, String, String> sr1 = SenderRecord.create(pr1, pr1.key());
        SenderRecord<String, String, String> sr2 = SenderRecord.create(pr2, pr2.key());
        
        return Flux.just(sr1, sr2);
    }

}

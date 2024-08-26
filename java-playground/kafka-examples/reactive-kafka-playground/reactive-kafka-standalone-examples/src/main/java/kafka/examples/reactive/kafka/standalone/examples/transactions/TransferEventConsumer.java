package kafka.examples.reactive.kafka.standalone.examples.transactions;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.kafka.receiver.KafkaReceiver;
import reactor.kafka.receiver.ReceiverRecord;

@Slf4j
public class TransferEventConsumer {

    private final KafkaReceiver<String, String> receiver;

    public TransferEventConsumer(KafkaReceiver<String, String> receiver) {
        this.receiver = receiver;
    }

    public Flux<TransferEvent> receive(){
        return this.receiver.receive()
                .doOnNext(r -> log.info("key: {}, value: {}", r.key(), r.value()))
                .map(this::toTransferEvent);
    }

    // 1:a,b,10 - "1" is the key, "a" is the from account, "b" is the to account and "10" is the amount.
    private TransferEvent toTransferEvent(ReceiverRecord<String, String> record){
        var arr = record.value().split(",");

        // To simulate error behavior
        var runnable = record.key().equals("6") ? fail() : ack(record);
        return new TransferEvent(
                record.key(),
                arr[0],
                arr[1],
                arr[2],
                runnable
        );
    }

    private Runnable ack(ReceiverRecord<String, String> record){
        return () -> record.receiverOffset().acknowledge();
    }

    private Runnable fail(){
        return () -> { throw new RuntimeException("error while ack");  };
    }

}

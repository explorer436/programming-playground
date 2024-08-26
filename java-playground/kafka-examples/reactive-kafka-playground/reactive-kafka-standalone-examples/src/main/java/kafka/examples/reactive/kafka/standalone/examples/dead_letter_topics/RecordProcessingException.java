package kafka.examples.reactive.kafka.standalone.examples.dead_letter_topics;

import reactor.kafka.receiver.ReceiverRecord;

public class RecordProcessingException extends RuntimeException{

    private final ReceiverRecord<?, ?> record;

    public RecordProcessingException(ReceiverRecord<?, ?> record, Throwable e) {
        super(e);
        this.record = record;
    }

    @SuppressWarnings("unchecked")
    public <K, V> ReceiverRecord<K, V> getRecord() {
        return (ReceiverRecord<K, V>) record;
    }

}

package com.my.company.cloud_stream_kafka_playground.sec05_acknowledging;

import reactor.kafka.receiver.ReceiverOffset;

public record Record<T>(String key,
                        T message,
                        ReceiverOffset acknowledgement) {
}


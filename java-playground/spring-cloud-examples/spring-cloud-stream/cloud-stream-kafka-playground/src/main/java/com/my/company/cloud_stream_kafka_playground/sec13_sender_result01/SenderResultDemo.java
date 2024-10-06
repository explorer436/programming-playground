package com.my.company.cloud_stream_kafka_playground.sec13_sender_result01;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.channel.FluxMessageChannel;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.kafka.sender.SenderResult;

@Service
@Slf4j
public class SenderResultDemo {

    @Autowired
    private FluxMessageChannel channel;

    @PostConstruct
    private void init() {

        // See FluxMessageChannel.doSend()
        // They are wrapping the SenderResult in a Flux and returning it.

        Flux.from(channel)
                .map(Message::getPayload)
                .cast(SenderResult.class)
                .doOnNext(r -> log.info("received result id {}, record metadata {}", r.correlationMetadata(), r.recordMetadata()))
                .subscribe();

    }

    /*
        Output:
        2024-10-06T17:31:37.284-04:00  INFO 56191 --- [cloud-stream-kafka-playground] [     parallel-3] o.a.k.c.t.i.KafkaMetricsCollector        : initializing Kafka metrics collector
        2024-10-06T17:31:37.290-04:00  INFO 56191 --- [cloud-stream-kafka-playground] [     parallel-3] o.a.kafka.common.utils.AppInfoParser     : Kafka version: 3.7.1
        2024-10-06T17:31:37.290-04:00  INFO 56191 --- [cloud-stream-kafka-playground] [     parallel-3] o.a.kafka.common.utils.AppInfoParser     : Kafka commitId: e2494e6ffb89f828
        2024-10-06T17:31:37.291-04:00  INFO 56191 --- [cloud-stream-kafka-playground] [     parallel-3] o.a.kafka.common.utils.AppInfoParser     : Kafka startTimeMs: 1728250297290
        2024-10-06T17:31:37.297-04:00  INFO 56191 --- [cloud-stream-kafka-playground] [ad | producer-2] org.apache.kafka.clients.Metadata        : [Producer clientId=producer-2] Cluster ID: OTMwNzFhYTY1ODNiNGE5OQ
        2024-10-06T17:31:37.383-04:00  INFO 56191 --- [cloud-stream-kafka-playground] [ad | producer-2] c.m.c.c.s.SenderResultDemo               : received result id 0, record metadata input-topic-0@0
        2024-10-06T17:31:38.256-04:00  INFO 56191 --- [cloud-stream-kafka-playground] [     parallel-3] c.m.c.c.s.KafkaProducer                  : produced GenericMessage [payload=msg 1, headers={correlationId=1, id=ae3c2d63-d669-91db-1964-7f92f61ecd6f, kafka_messageKey=key-1, timestamp=1728250298256}]
        2024-10-06T17:31:38.260-04:00  INFO 56191 --- [cloud-stream-kafka-playground] [ad | producer-2] c.m.c.c.s.SenderResultDemo               : received result id 1, record metadata input-topic-0@1
        2024-10-06T17:31:39.255-04:00  INFO 56191 --- [cloud-stream-kafka-playground] [     parallel-3] c.m.c.c.s.KafkaProducer                  : produced GenericMessage [payload=msg 2, headers={correlationId=2, id=41d5f513-0285-9109-f8e8-4bd19911792e, kafka_messageKey=key-2, timestamp=1728250299255}]
        2024-10-06T17:31:39.260-04:00  INFO 56191 --- [cloud-stream-kafka-playground] [ad | producer-2] c.m.c.c.s.SenderResultDemo               : received result id 2, record metadata input-topic-0@2
        2024-10-06T17:31:40.255-04:00  INFO 56191 --- [cloud-stream-kafka-playground] [     parallel-3] c.m.c.c.s.KafkaProducer                  : produced GenericMessage [payload=msg 3, headers={correlationId=3, id=326e3d58-6555-062f-93ca-101923340127, kafka_messageKey=key-3, timestamp=1728250300255}]
        2024-10-06T17:31:40.260-04:00  INFO 56191 --- [cloud-stream-kafka-playground] [ad | producer-2] c.m.c.c.s.SenderResultDemo               : received result id 3, record metadata input-topic-0@3
        2024-10-06T17:31:41.255-04:00  INFO 56191 --- [cloud-stream-kafka-playground] [     parallel-3] c.m.c.c.s.KafkaProducer                  : produced GenericMessage [payload=msg 4, headers={correlationId=4, id=02de75e2-5e92-8c14-30a1-a20089f9a649, kafka_messageKey=key-4, timestamp=1728250301255}]
        2024-10-06T17:31:41.260-04:00  INFO 56191 --- [cloud-stream-kafka-playground] [ad | producer-2] c.m.c.c.s.SenderResultDemo               : received result id 4, record metadata input-topic-0@4
     */

}

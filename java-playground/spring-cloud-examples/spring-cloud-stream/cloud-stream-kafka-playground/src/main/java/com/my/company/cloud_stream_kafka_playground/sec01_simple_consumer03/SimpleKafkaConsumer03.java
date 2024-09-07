package com.my.company.cloud_stream_kafka_playground.sec01_simple_consumer03;

/*
    goal: to demo a simple kafka consumer using java functional interfaces
 */

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cloud.stream.binder.reactorkafka.ReceiverOptionsCustomizer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.kafka.receiver.ReceiverOptions;

import java.util.function.Consumer;
import java.util.function.Function;

@Configuration
@Slf4j
public class SimpleKafkaConsumer03 {

    @Bean
    public ReceiverOptionsCustomizer<String, ReceiverOptions> customizer(){
        return (str, receiverOptions) -> {
            log.info("******************************** {}", str);
            // ******************************** function3-in-0
            // str represents the name of the function
            return receiverOptions.consumerProperty(ConsumerConfig.GROUP_INSTANCE_ID_CONFIG, "234");
        };
    }

    /*
    # With this configuration,
    # when we start the application, we are supposed to see the "group.instance.id" in the logs:
        2024-09-07T11:50:51.335-04:00  INFO 59705 --- [cloud-stream-kafka-playground] [           main] o.a.k.clients.consumer.ConsumerConfig    : ConsumerConfig values:
	allow.auto.create.topics = true
	auto.commit.interval.ms = 100
	auto.include.jmx.reporter = true
	auto.offset.reset = earliest
	bootstrap.servers = [localhost:9092]
	check.crcs = true
	client.dns.lookup = use_all_dns_ips
	client.id = consumer-some-group-234
	client.rack =
	connections.max.idle.ms = 540000
	default.api.timeout.ms = 60000
	enable.auto.commit = false
	enable.metrics.push = true
	exclude.internal.topics = true
	fetch.max.bytes = 52428800
	fetch.max.wait.ms = 500
	fetch.min.bytes = 1
	group.id = some-group
	group.instance.id = 234
	...
	2024-09-07T11:50:51.362-04:00  INFO 59705 --- [cloud-stream-kafka-playground] [ka-some-group-1] org.apache.kafka.clients.Metadata        : [Consumer instanceId=234, clientId=consumer-some-group-234, groupId=some-group] Cluster ID: OTMwNzFhYTY1ODNiNGE5OQ
        2024-09-07T11:50:51.363-04:00  INFO 59705 --- [cloud-stream-kafka-playground] [ka-some-group-1] o.a.k.c.c.internals.ConsumerCoordinator  : [Consumer instanceId=234, clientId=consumer-some-group-234, groupId=some-group] Discovered group coordinator localhost:9092 (id: 2147483646 rack: null)
        2024-09-07T11:50:51.366-04:00  INFO 59705 --- [cloud-stream-kafka-playground] [ka-some-group-1] o.a.k.c.c.internals.ConsumerCoordinator  : [Consumer instanceId=234, clientId=consumer-some-group-234, groupId=some-group] (Re-)joining group
        2024-09-07T11:50:54.382-04:00  INFO 59705 --- [cloud-stream-kafka-playground] [ka-some-group-1] o.a.k.c.c.internals.ConsumerCoordinator  : [Consumer instanceId=234, clientId=consumer-some-group-234, groupId=some-group] Successfully joined group with generation Generation{generationId=1, memberId='234-474de69f-b006-4027-a508-69e49ca0651e', protocol='range'}
        2024-09-07T11:50:54.394-04:00  INFO 59705 --- [cloud-stream-kafka-playground] [ka-some-group-1] o.a.k.c.c.internals.ConsumerCoordinator  : [Consumer instanceId=234, clientId=consumer-some-group-234, groupId=some-group] Finished assignment for group at generation 1: {234-474de69f-b006-4027-a508-69e49ca0651e=Assignment(partitions=[input-topic-0])}
        2024-09-07T11:50:54.401-04:00  INFO 59705 --- [cloud-stream-kafka-playground] [ka-some-group-1] o.a.k.c.c.internals.ConsumerCoordinator  : [Consumer instanceId=234, clientId=consumer-some-group-234, groupId=some-group] Successfully synced group in generation Generation{generationId=1, memberId='234-474de69f-b006-4027-a508-69e49ca0651e', protocol='range'}
        2024-09-07T11:50:54.402-04:00  INFO 59705 --- [cloud-stream-kafka-playground] [ka-some-group-1] o.a.k.c.c.internals.ConsumerCoordinator  : [Consumer instanceId=234, clientId=consumer-some-group-234, groupId=some-group] Notifying assignor about the new Assignment(partitions=[input-topic-0])
        2024-09-07T11:50:54.405-04:00  INFO 59705 --- [cloud-stream-kafka-playground] [ka-some-group-1] k.c.c.i.ConsumerRebalanceListenerInvoker : [Consumer instanceId=234, clientId=consumer-some-group-234, groupId=some-group] Adding newly assigned partitions: input-topic-0
        2024-09-07T11:50:54.406-04:00  INFO 59705 --- [cloud-stream-kafka-playground] [ka-some-group-1] o.s.c.s.b.r.ReactorKafkaBinder           : Assigned: [input-topic-0]
        2024-09-07T11:50:54.416-04:00  INFO 59705 --- [cloud-stream-kafka-playground] [ka-some-group-1] o.a.k.c.c.internals.ConsumerCoordinator  : [Consumer instanceId=234, clientId=consumer-some-group-234, groupId=some-group] Found no committed offset for partition input-topic-0
        2024-09-07T11:50:54.431-04:00  INFO 59705 --- [cloud-stream-kafka-playground] [ka-some-group-1] o.a.k.c.c.internals.SubscriptionState    : [Consumer instanceId=234, clientId=consumer-some-group-234, groupId=some-group] Resetting offset for partition input-topic-0 to position FetchPosition{offset=0, offsetEpoch=Optional.empty, currentLeader=LeaderAndEpoch{leader=Optional[localhost:9092 (id: 1 rack: null)], epoch=0}}.
        2024-09-07T11:50:54.473-04:00  INFO 59705 --- [cloud-stream-kafka-playground] [ka-some-group-1] c.m.c.c.s.SimpleKafkaConsumer03          : function received abcd
     */

    @Bean
    public Consumer<Flux<String>> consumer3() {
        return flux -> flux
                .doOnNext(s -> log.info("consumer received {}", s))
                .subscribe();
    }

    // Re-writing the above function without subscribe().
    // Give Mono<Void> back.
    @Bean
    public Function<Flux<String>, Mono<Void>> function3() {
        return flux -> flux
                .doOnNext(s -> log.info("function received {}", s))
                .then();
    }

}

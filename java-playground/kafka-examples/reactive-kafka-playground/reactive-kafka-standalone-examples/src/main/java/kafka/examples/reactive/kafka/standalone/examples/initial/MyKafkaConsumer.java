package kafka.examples.reactive.kafka.standalone.examples.initial;

import java.util.List;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.OffsetResetStrategy;
import org.apache.kafka.common.serialization.StringDeserializer;

import lombok.extern.slf4j.Slf4j;
import reactor.kafka.receiver.KafkaReceiver;
import reactor.kafka.receiver.ReceiverOptions;

@Slf4j
public class MyKafkaConsumer {

    // In order to start listening, just start the main method.
    public static void main(String[] args) {

        Map<String, Object> consumerConfig = Map.<String, Object>of(
                ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092",
                ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class,
                ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class,
                ConsumerConfig.GROUP_ID_CONFIG, "demo-group-123",
                ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, OffsetResetStrategy.EARLIEST.toString(),
                ConsumerConfig.GROUP_INSTANCE_ID_CONFIG, "1"
        );

        ReceiverOptions<Object, Object> options = ReceiverOptions
                .create(consumerConfig)
                // we can consume from more than one topics
                .subscription(List.of("order-events", "order-returns"));
                // .subscription(Pattern.compile("order.*"));

        KafkaReceiver.create(options)
                .receive()
                .doOnNext(r -> log.info("topic: {}, key: {}, value: {}", r.topic(), r.key(), r.value()))
                // acknowledge after processing the message. Not before.
                .doOnNext(r -> r.receiverOffset().acknowledge())
                .subscribe();

        // Don't we have to block this thread?
        // No, this does not run on the main thread.
        // It runs on a daemon thread. And it will keep listening on the daemon thread.
    }
}
    
        /**
         * 
            What are the properties that we can configure/customize?
            We will see that list at start-up, in the logs).
            We need to look at the documentation to see what each of these does.

            11:59:59.964 [main] INFO  o.a.k.c.consumer.ConsumerConfig - ConsumerConfig values: 
            allow.auto.create.topics = true
            auto.commit.interval.ms = 5000
            auto.include.jmx.reporter = true
            auto.offset.reset = earliest
            bootstrap.servers = [localhost:9092]
            check.crcs = true
            client.dns.lookup = use_all_dns_ips
            client.id = consumer-demo-group-123-1
            client.rack = 
            connections.max.idle.ms = 540000
            default.api.timeout.ms = 60000
            enable.auto.commit = false
            enable.metrics.push = true
            exclude.internal.topics = true
            fetch.max.bytes = 52428800
            fetch.max.wait.ms = 500
            fetch.min.bytes = 1
            group.id = demo-group-123
            group.instance.id = 1
            group.protocol = classic
            group.remote.assignor = null
            heartbeat.interval.ms = 3000
            interceptor.classes = []
            internal.leave.group.on.close = true
            internal.throw.on.fetch.stable.offset.unsupported = false
            isolation.level = read_uncommitted
            key.deserializer = class org.apache.kafka.common.serialization.StringDeserializer
            max.partition.fetch.bytes = 1048576
            max.poll.interval.ms = 300000
            max.poll.records = 500
            metadata.max.age.ms = 300000
            metric.reporters = []
            metrics.num.samples = 2
            metrics.recording.level = INFO
            metrics.sample.window.ms = 30000
            partition.assignment.strategy = [class org.apache.kafka.clients.consumer.RangeAssignor, class org.apache.kafka.clients.consumer.CooperativeStickyAssignor]
            receive.buffer.bytes = 65536
            reconnect.backoff.max.ms = 1000
            reconnect.backoff.ms = 50
            request.timeout.ms = 30000
            retry.backoff.max.ms = 1000
            retry.backoff.ms = 100
            sasl.client.callback.handler.class = null
            sasl.jaas.config = null
            sasl.kerberos.kinit.cmd = /usr/bin/kinit
            sasl.kerberos.min.time.before.relogin = 60000
            sasl.kerberos.service.name = null
            sasl.kerberos.ticket.renew.jitter = 0.05
            sasl.kerberos.ticket.renew.window.factor = 0.8
            sasl.login.callback.handler.class = null
            sasl.login.class = null
            sasl.login.connect.timeout.ms = null
            sasl.login.read.timeout.ms = null
            sasl.login.refresh.buffer.seconds = 300
            sasl.login.refresh.min.period.seconds = 60
            sasl.login.refresh.window.factor = 0.8
            sasl.login.refresh.window.jitter = 0.05
            sasl.login.retry.backoff.max.ms = 10000
            sasl.login.retry.backoff.ms = 100
            sasl.mechanism = GSSAPI
            sasl.oauthbearer.clock.skew.seconds = 30
            sasl.oauthbearer.expected.audience = null
            sasl.oauthbearer.expected.issuer = null
            sasl.oauthbearer.jwks.endpoint.refresh.ms = 3600000
            sasl.oauthbearer.jwks.endpoint.retry.backoff.max.ms = 10000
            sasl.oauthbearer.jwks.endpoint.retry.backoff.ms = 100
            sasl.oauthbearer.jwks.endpoint.url = null
            sasl.oauthbearer.scope.claim.name = scope
            sasl.oauthbearer.sub.claim.name = sub
            sasl.oauthbearer.token.endpoint.url = null
            security.protocol = PLAINTEXT
            security.providers = null
            send.buffer.bytes = 131072
            session.timeout.ms = 45000
            socket.connection.setup.timeout.max.ms = 30000
            socket.connection.setup.timeout.ms = 10000
            ssl.cipher.suites = null
            ssl.enabled.protocols = [TLSv1.2, TLSv1.3]
            ssl.endpoint.identification.algorithm = https
            ssl.engine.factory.class = null
            ssl.key.password = null
            ssl.keymanager.algorithm = SunX509
            ssl.keystore.certificate.chain = null
            ssl.keystore.key = null
            ssl.keystore.location = null
            ssl.keystore.password = null
            ssl.keystore.type = JKS
            ssl.protocol = TLSv1.3
            ssl.provider = null
            ssl.secure.random.implementation = null
            ssl.trustmanager.algorithm = PKIX
            ssl.truststore.certificates = null
            ssl.truststore.location = null
            ssl.truststore.password = null
            ssl.truststore.type = JKS
            value.deserializer = class org.apache.kafka.common.serialization.StringDeserializer
         * 
         */

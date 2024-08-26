package kafka.examples.reactive.kafka.standalone.examples.usingactualproducersandconsumers;

import kafka.examples.reactive.kafka.standalone.examples.withspring.model.OrderEvent;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import reactor.core.publisher.Flux;
import reactor.kafka.receiver.KafkaReceiver;
import reactor.kafka.receiver.ReceiverRecord;
import reactor.test.StepVerifier;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@TestPropertySource(properties = "app=producer")
@Slf4j
public class OrderEventProducerTest extends AbstractIntegrationTest {

    // Both of these test methods are doing similar things - to demonstrate the use of DirtiesContext
    // If we don't use DirtiesContext, the same messages will be used by the other test methods. Each test method will not produce it's own messages to the test topic.

    // This is to test src/main/java/kafka/examples/reactive.kafka.playground/withspring/MyProducerRunner.java
    // MyProducerRunner.java will keep emitting messages based on the criteria in it's "orderFlux()".

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void producerTest1() {

        // Create a receiver on the fly for the purpose of this test case.
        // The test case has to use the same model and topic names that the producer is using.
        KafkaReceiver<String, OrderEvent> receiver = createReceiver("kafka.examples.reactive.kafka.playground.withspring.model", "order-events");
        Flux<ReceiverRecord<String, OrderEvent>> orderEvents = receiver
                .receive()
                .take(10)
                .doOnNext(r -> log.info("Message received by the test case: key: {}, value: {}", r.key(), r.value()));

        // Why are the OrderEvent.customerId in the test results always 0,1,2,...9
        // Because, every time the test is run, the producer is started in the dummy EmbeddedKafka container.
        // If the producer is writing to the actual kafka cluster, the OrderEvent.customerId values will vary and we will have no way of predicting those ids.

        // Why is the expected count of OrderEvents always 10?
        // Because, the receiver is only reading the first 10 messages from the topic.

        StepVerifier.create(orderEvents)
                .consumeNextWith(r -> assertAll(
                        "Grouped Assertions of OrderEvent",
                        () -> assertNotNull(r.value().orderId()),
                        () -> assertEquals(0, r.value().customerId()))
                )
                .consumeNextWith(r -> assertAll(
                        "Grouped Assertions of OrderEvent",
                        () -> assertNotNull(r.value().orderId()),
                        () -> assertEquals(1, r.value().customerId()))
                )
                .consumeNextWith(r -> assertAll(
                        "Grouped Assertions of OrderEvent",
                        () -> assertNotNull(r.value().orderId()),
                        () -> assertEquals(2, r.value().customerId()))
                )
                .consumeNextWith(r -> assertAll(
                        "Grouped Assertions of OrderEvent",
                        () -> assertNotNull(r.value().orderId()),
                        () -> assertEquals(3, r.value().customerId()))
                )
                .consumeNextWith(r -> assertAll(
                        "Grouped Assertions of OrderEvent",
                        () -> assertNotNull(r.value().orderId()),
                        () -> assertEquals(4, r.value().customerId()))
                )
                .expectNextCount(5)
                .expectComplete()
                .verify(Duration.ofSeconds(10));
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void producerTest2() {
        KafkaReceiver<String, OrderEvent> receiver = createReceiver("kafka.examples.reactive.kafka.playground.withspring.model", "order-events");
        Flux<ReceiverRecord<String, OrderEvent>> orderEvents = receiver.receive()
                .take(10)
                .doOnNext(r -> log.info("key: {}, value: {}", r.key(), r.value()));

        StepVerifier.create(orderEvents)
                .consumeNextWith(r -> assertNotNull(r.value().orderId()))
                .expectNextCount(9)
                .expectComplete()
                .verify(Duration.ofSeconds(10));
    }

}

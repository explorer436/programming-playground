package kafka.examples.reactive.kafka.standalone.examples.usingactualproducersandconsumers;

import kafka.examples.reactive.kafka.standalone.examples.withspring.model.DummyOrder;
import kafka.examples.reactive.kafka.standalone.examples.withspring.model.OrderEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;
import org.springframework.test.context.TestPropertySource;
import reactor.core.publisher.Mono;
import reactor.kafka.sender.KafkaSender;
import reactor.kafka.sender.SenderRecord;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;

@ExtendWith(OutputCaptureExtension.class)
@TestPropertySource(properties = "app=consumer")
public class OrderEventConsumerTest extends AbstractIntegrationTest {

    @Test
    public void consumerTest(CapturedOutput output){

        var uuid = UUID.randomUUID();
        OrderEvent orderEvent = new OrderEvent(uuid, 1, LocalDateTime.now());
        DummyOrder dummyOrder = new DummyOrder(uuid.toString(), "1");
        // This has to be the exact topic that MyConsumerRunner.java is listening on.
        // In other words, the same topic name from src/main/java/kafka/examples/reactive.kafka.playground/withspring/MyKafkaConsumerConfig.java
        SenderRecord<String, OrderEvent, String> sr = toSenderRecord("order-events", "1", orderEvent);

        // Create a sender on the fly (instead of using the one in the main package) and use it to send messages to the test topic.
        KafkaSender<String, OrderEvent> sender = createSender();
        Mono<Void> mono = sender.send(Mono.just(sr))
                // Why do we need this delay? If the test runs super fast, it will not wait for the message to be published and read. That process takes a little bit of time.
                .then(Mono.delay(Duration.ofMillis(500)))
                .then();

        StepVerifier.create(mono).verifyComplete();

        // Making sure that the consumer in the main package (src/main/java/kafka/examples/reactive.kafka.playground/withspring/MyConsumerRunner.java) is reading this exact same test message successfully.
        // Where are we getting "output" from?
        // We get it from src/main/java/kafka/examples/reactive.kafka.playground/withspring/MyConsumerRunner.java
        Assertions.assertTrue(output.getOut().contains(dummyOrder.toString()));
    }

}
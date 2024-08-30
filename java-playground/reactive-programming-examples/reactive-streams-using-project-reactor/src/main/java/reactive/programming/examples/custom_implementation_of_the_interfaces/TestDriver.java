package reactive.programming.examples.custom_implementation_of_the_interfaces;

import lombok.extern.slf4j.Slf4j;
import reactive.programming.examples.custom_implementation_of_the_interfaces.publisher.PublisherImpl;
import reactive.programming.examples.custom_implementation_of_the_interfaces.subscriber.SubscriberImpl;

import java.time.Duration;

@Slf4j
public class TestDriver {
    public static void main(String[] args) throws InterruptedException {
        /*validate_1();
        validate_2();
        validate_3();
        validate_4();*/
        validate_5();
    }

    // publisher does not produce data unless subscriber requests for it.
    private static void validate_1() {
        PublisherImpl publisher = new PublisherImpl();
        SubscriberImpl subscriber = new SubscriberImpl();

        publisher.subscribe(subscriber);
    }

    // publisher will produce only when the subscriber requests items.
    private static void validate_2() throws InterruptedException {
        PublisherImpl publisher = new PublisherImpl();
        SubscriberImpl subscriber = new SubscriberImpl();

        publisher.subscribe(subscriber);

        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2));
        log.info("-------");

        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2));
        log.info("-------");

        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2));
        log.info("-------");

        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2));
        log.info("-------");

        // Note that the subscriber will only get 10 items and not 12.
    }

    // publisher can also produce 0 items.
    private static void validate_3() {
        PublisherImpl publisher = new PublisherImpl();
        SubscriberImpl subscriber = new SubscriberImpl();

        publisher.subscribe(subscriber);

        // Change the value of SubscriptionImpl.MAX_ITEMS to 0 before running this.
        subscriber.getSubscription().request(3);
    }

    // subscriber can cancel the subscriptions.
    // publisher should stop at that moment as subscriber is no longer interested in consuming the data.
    private static void validate_4() throws InterruptedException {
        PublisherImpl publisher = new PublisherImpl();
        SubscriberImpl subscriber = new SubscriberImpl();

        publisher.subscribe(subscriber);

        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2));
        log.info("-------");

        subscriber.getSubscription().cancel();

        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2));
        log.info("-------");

        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2));
        log.info("-------");

        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2));
        log.info("-------");
    }

    // publisher can send error signal to indicate that something went wrong.
    private static void validate_5() throws InterruptedException {
        PublisherImpl publisher = new PublisherImpl();
        SubscriberImpl subscriber = new SubscriberImpl();

        publisher.subscribe(subscriber);

        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2));
        log.info("-------");

        subscriber.getSubscription().request(33);
        Thread.sleep(Duration.ofSeconds(2));
        log.info("-------");

        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2));
        log.info("-------");

        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2));
        log.info("-------");
    }
}

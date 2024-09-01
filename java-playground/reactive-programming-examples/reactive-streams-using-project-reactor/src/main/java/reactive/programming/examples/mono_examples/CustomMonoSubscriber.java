package reactive.programming.examples.mono_examples;

import lombok.extern.slf4j.Slf4j;
import reactive.programming.examples.custom_implementation_of_the_interfaces.subscriber.SubscriberImpl;
import reactor.core.publisher.Mono;

/**
 * Creating a mono and subscribing to it using our own custom subscriber
 */
@Slf4j
public class CustomMonoSubscriber {
    public static void main(String[] args) {
        Mono<String> mono = Mono.just("hello");

        log.info(String.valueOf(mono)); // doesn't print anything

        // This is the most straight-forward way to use the mono.
        // mono.subscribe();

        SubscriberImpl subscriber = new SubscriberImpl();
        mono.subscribe(subscriber);
        subscriber.getSubscription().request(10);

        // adding these will have no effect as producer already sent complete
        subscriber.getSubscription().request(10);
        subscriber.getSubscription().cancel();
    }
}

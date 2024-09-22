package reactive.programming.examples.sec02mono_examples;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
public class Lec02MonoSubscribe {

    /*
       Not using the custom SubscriberImpl anymore.
       We build subscribers on the fly using Functional approach.
     */

    public static void main(String[] args) {
        // subscribe_example1();
        // subscribe_example2();
        subscribe_example3();
    }

    public static void subscribe_example1() {
        Mono<Integer> mono = Mono.just(1);

        /*
            subscribe() method is overloaded.
            We can just write the first statement, and it would still be ok.
         */
        mono.subscribe(
                i -> log.info("received: {}", i),
                err -> log.error("error", err),
                () -> log.info("completed")
        );

        /*
           How are we receiving values without explicitly calling the "request()" method?
           The reactive library will call the request() for us.
           But we can also do it manually.
         */
    }

    public static void subscribe_example2() {
        Mono<Integer> mono = Mono.just(1);

        /*
            Calling the request() exclusively
         */
        mono.subscribe(
                i -> log.info("received: {}", i),
                err -> log.error("error", err),
                () -> log.info("completed"),
                subscription -> subscription.request(3)
                // subscription -> subscription.cancel()
        );
    }

    public static void subscribe_example3() {
        /*
            error scenario
         */

        Mono<Integer> mono = Mono.just(1)
                        .map(i -> i/0);
        mono.subscribe(
                i -> log.info("received: {}", i),
                err -> log.error("error", err),
                () -> log.info("completed"),
                subscription -> subscription.request(3)
                // subscription -> subscription.cancel()
        );
    }
}

package reactive.programming.examples.sec06operators;

import lombok.extern.slf4j.Slf4j;
import reactive.programming.examples.utilities.Util;
import reactor.core.publisher.Mono;

import java.time.Duration;

/*
    timeout - will produce timeout error.
        - We can handle as part of onError methods
    there is also an overloaded method to accept a publisher
    we can have multiple timeouts. the closest one to the subscriber will take effect for the subscriber.
 */
@Slf4j
public class Lec09Timeout {

    public static void main(String[] args) {

        getProductName()
                .timeout(Duration.ofSeconds(1), fallback())
                .subscribe(Util.subscriber());

        Util.sleepSeconds(5);

    }

    private static Mono<String> getProductName() {
        return Mono.fromSupplier(() -> "service-" + Util.getFaker().commerce().productName())
                   .delayElement(Duration.ofMillis(1900));
    }

    private static Mono<String> fallback() {
        return Mono.fromSupplier(() -> "fallback-" + Util.getFaker().commerce().productName())
                   .delayElement(Duration.ofMillis(300))
                   .doFirst(() -> log.info("do first"));
    }

}

package reactive.programming.examples.sec03flux_examples_with_in_memory_data;

import reactive.programming.examples.utilities.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

/**
 * To emit a message based on the given interval
 */
public class Lec09FluxInterval {

    public static void main(String[] args) {

        Flux.interval(Duration.ofMillis(500))
                .map(i -> Util.getFaker().name().firstName())
                .subscribe(Util.subscriber());

        Util.sleepSeconds(5);

    }

}

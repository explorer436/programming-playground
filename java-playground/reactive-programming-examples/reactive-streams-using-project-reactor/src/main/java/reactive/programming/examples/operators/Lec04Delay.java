package reactive.programming.examples.operators;

import reactive.programming.examples.util.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec04Delay {

    public static void main(String[] args) {

        Flux.range(1, 10)
                .log()
                .delayElements(Duration.ofSeconds(1))
                .subscribe(Util.subscriber());

        // Each item is requested from the Producer after 1 second.
        // Until an item is requested, the Producer will not do the work - it is lazy by default.

        Util.sleepSeconds(12);

    }


}

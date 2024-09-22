package reactive.programming.examples.sec04flux_emitting_items_programmatically;

import reactive.programming.examples.utilities.Util;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Stopping the execution in the Producer instead of using operators
 */
public class Lec08GenerateWithState {

    public static void main(String[] args) {

        generatorWithState2();

    }

    private static void generatorWithState1() {

        /**
         * DO NOT USE.
         * This approach is not preferable because the counter is outside the Producer.
         * It is subject to mutations outside the Producer.
         */

        AtomicInteger atomicInteger = new AtomicInteger(0);
        Flux.generate(synchronousSink -> {
                            var country = Util.getFaker().country().name();
                            synchronousSink.next(country);
                            atomicInteger.incrementAndGet();
                            if (atomicInteger.get() == 10 || country.equalsIgnoreCase("canada")) {
                                synchronousSink.complete();
                            }
                        }
                )
                .subscribe(Util.subscriber());
    }

    private static void generatorWithState2() {
        Flux.generate(
                        () -> 0,
                        (counter, synchronousSink) -> {
                            var country = Util.getFaker().country().name();
                            synchronousSink.next(country);
                            counter++;
                            if (counter == 10 || country.equalsIgnoreCase("canada")) {
                                synchronousSink.complete();
                            }
                            return counter;
                        }
                )
                .subscribe(Util.subscriber());
    }

}

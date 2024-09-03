package reactive.programming.examples.flux_emitting_items_programmatically;

import reactive.programming.examples.util.Util;
import reactor.core.publisher.Flux;

/**
 *  Take is similar to java stream's limit
 */
public class Lec05TakeOperator {

    public static void main(String[] args) {

        // take();
        // takeWhile();
        takeUntil();

    }

    private static void take(){
        Flux.range(1, 10)
            .log("take")
            .take(3)
            .log("sub")
            .subscribe(Util.subscriber());
    }

    private static void takeWhile() {
        Flux.range(1, 10)
            .log("take")
            .takeWhile(i -> i < 5) // stop when the condition is not met
            .log("sub")
            .subscribe(Util.subscriber());
    }

    /**
     * Relay values from this Flux until the given Predicate matches.
     * Stops on the first match.
     */
    private static void takeUntil() {
        Flux.range(1, 10)
            .log("take")
            .takeUntil(i -> i < 5) // stop when the condition is met + allow the last item
            .log("sub")
            .subscribe(Util.subscriber());
    }

}

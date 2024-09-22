package reactive.programming.examples.sec03flux_examples_with_in_memory_data;

import reactive.programming.examples.utilities.Util;
import reactor.core.publisher.Flux;

/**
 *  To create a Flux with arbitrary items in memory
 */
public class Lec01CustomFluxSubscriber {
    public static void main(String[] args) {
        Flux.just(1, 2, 3, "sam")
                .subscribe(Util.subscriber());
    }
}

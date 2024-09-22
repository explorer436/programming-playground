package reactive.programming.examples.sec03flux_examples_with_in_memory_data;

import reactive.programming.examples.utilities.Util;
import reactor.core.publisher.Flux;

/**
 * To create empty/error flux
 */
public class Lec10FluxEmptyError {

    public static void main(String[] args) {

        Flux.empty()
                .subscribe(Util.subscriber());

        Flux.error(new RuntimeException("oops"))
                .subscribe(Util.subscriber());

    }

}

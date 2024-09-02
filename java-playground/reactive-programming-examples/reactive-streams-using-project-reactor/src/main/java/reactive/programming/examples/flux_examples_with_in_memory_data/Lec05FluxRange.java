package reactive.programming.examples.flux_examples_with_in_memory_data;

import reactive.programming.examples.util.Util;
import reactor.core.publisher.Flux;

/**
 *  To create a range of items based on the given start and count
 */
public class Lec05FluxRange {

    public static void main(String[] args) {

        Flux.range(3, 10)
                .subscribe(Util.subscriber("sub1"));

        // assignment - generate 10 random first names
        Flux.range(1, 10)
                .map(i -> Util.getFaker().name().firstName())
                .subscribe(Util.subscriber("sub2"));

    }

}

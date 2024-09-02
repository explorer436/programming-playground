package reactive.programming.examples.flux_examples_with_in_memory_data;

import reactive.programming.examples.util.Util;
import reactor.core.publisher.Flux;

/**
 *  To demo filter / map operators
 */
public class Lec02FluxMultipleSubscribers_FilterMapOperators {

    public static void main(String[] args) {

        Flux<Integer> flux = Flux.just(1, 2, 3, 4, 5, 6);

        flux.subscribe(Util.subscriber("sub1"));
        
        flux.filter(i -> i > 7)
                .subscribe(Util.subscriber("sub2"));

        flux
                .filter(i -> i % 2 == 0)
                .map(i -> i + "a")
                .subscribe(Util.subscriber("sub3"));

    }

}

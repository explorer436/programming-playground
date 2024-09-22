package reactive.programming.examples.sec03flux_examples_with_in_memory_data;

import reactive.programming.examples.utilities.Util;
import reactor.core.publisher.Flux;

import java.util.List;

/**
 *  To create flux from iterable or array
 */
public class Lec03FluxFromIterableOrArray {

    public static void main(String[] args) {

        List<String> list = List.of("a", "b", "c");
        Flux.fromIterable(list)
                .subscribe(Util.subscriber());

        Integer[] arr = {1,2,3,4,5,6};
        Flux.fromArray(arr)
                .subscribe(Util.subscriber());

    }

}

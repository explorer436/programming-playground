package reactive.programming.examples.flux_examples_with_in_memory_data;

import java.util.List;
import java.util.stream.Stream;

import reactive.programming.examples.util.Util;
import reactor.core.publisher.Flux;

/**
 *  To create flux from stream
 */
public class Lec04FluxFromStream {

    public static void main(String[] args) {

        List<Integer> list = List.of(1, 2, 3, 4);
        Stream<Integer> stream = list.stream();

        // We cannot use java streams more than once.
        // stream.forEach(System.out::println);
        // stream.forEach(System.out::println);

        var flux = Flux.fromStream(list::stream);

        flux.subscribe(Util.subscriber("sub1"));
        flux.subscribe(Util.subscriber("sub2"));

    }

}
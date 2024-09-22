package reactive.programming.examples.sec03flux_examples_with_in_memory_data;

import reactive.programming.examples.utilities.Util;
import reactor.core.publisher.Flux;

public class Lec06Log {

    public static void main(String[] args) {

        Flux.range(1, 5)
                .log() // this is a consumer to the Flux range
                .map(i -> Util.getFaker().name().firstName())
                .log() // this is a producer to the subscriber
                .subscribe(Util.subscriber());

    }

}

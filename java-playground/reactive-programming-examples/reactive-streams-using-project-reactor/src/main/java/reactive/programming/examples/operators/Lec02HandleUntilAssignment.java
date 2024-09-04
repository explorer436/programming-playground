package reactive.programming.examples.operators;

import reactive.programming.examples.util.Util;
import reactor.core.publisher.Flux;

public class Lec02HandleUntilAssignment {
    public static void main(String[] args) {
        // Objective: implement demo2() using handle()
        handle2();
    }

    private static void handle2() {
        Flux.<String>generate(synchronousSink -> {
                    synchronousSink.next(Util.getFaker().country().name());
                })
                .handle((item, synchronousSink) -> {
                    synchronousSink.next(item);
                    if (item.equalsIgnoreCase("canada")) {
                        synchronousSink.complete();
                    }
                })
                .subscribe(Util.subscriber());
    }

    /*private static void demo2() {
        Flux.<String>generate(synchronousSink -> {
                    var country = Util.getFaker().country().name();
                    synchronousSink.next(country);
                })
                .takeUntil(c -> c.equalsIgnoreCase("canada"))
                .subscribe(Util.subscriber());
    }*/
}

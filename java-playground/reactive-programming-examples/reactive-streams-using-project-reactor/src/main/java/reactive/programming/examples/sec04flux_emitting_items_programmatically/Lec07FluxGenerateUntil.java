package reactive.programming.examples.sec04flux_emitting_items_programmatically;

import reactive.programming.examples.utilities.Util;
import reactor.core.publisher.Flux;

public class Lec07FluxGenerateUntil {

    public static void main(String[] args) {

        // demo1();
        demo2();

    }

    private static void demo1() {
        Flux.generate(synchronousSink -> {
                    String country = Util.getFaker().country().name();
                    synchronousSink.next(country);
                    if (country.equalsIgnoreCase("canada")) {
                        synchronousSink.complete();
                    }
                })
                .subscribe(Util.subscriber());
    }

    private static void demo2() {
        Flux.<String>generate(synchronousSink -> {
                var country = Util.getFaker().country().name();
                synchronousSink.next(country);
            })
            .takeUntil(c -> c.equalsIgnoreCase("canada"))
            .subscribe(Util.subscriber());
    }

}

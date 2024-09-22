package reactive.programming.examples.sec04flux_emitting_items_programmatically;

import reactive.programming.examples.utilities.Util;
import reactor.core.publisher.Flux;

/**
 *  To create a flux & emit items programmatically
 */
public class Lec01FluxCreate {

    public static void main(String[] args) {

        Flux.create(sink -> {
            sink.next(1);
            sink.next(2);
            sink.next(3);
            sink.complete();
        }).subscribe(Util.subscriber("sub1"));

        Flux.create(sink -> {
                    for (int i = 0; i < 10; i++) {
                        sink.next(Util.getFaker().country().name());
                    }

                    sink.complete();
                })
                .subscribe(Util.subscriber("sub2"));

        Flux.create(sink -> {
                    String country;
                    do {
                        country = Util.getFaker().country().name();
                        sink.next(country);
                    } while (!country.equalsIgnoreCase("canada"));

                    sink.complete();
                })
                .subscribe(Util.subscriber("sub3"));

    }

}

package reactive.programming.examples.flux_emitting_items_programmatically;

import reactive.programming.examples.util.Util;
import reactor.core.publisher.Flux;

/**
 *  To create a flux & emit items programmatically
 */
public class Lec01FluxCreate {

    public static void main(String[] args) {

        Flux.create(fluxSink -> {
            fluxSink.next(1);
            fluxSink.next(2);
            fluxSink.next(3);
            fluxSink.complete();
        }).subscribe(Util.subscriber("sub1"));

        Flux.create(fluxSink -> {
                    for (int i = 0; i < 10; i++) {
                        fluxSink.next(Util.getFaker().country().name());
                    }

                    fluxSink.complete();
                })
                .subscribe(Util.subscriber("sub2"));

        Flux.create(fluxSink -> {
                    String country;
                    do {
                        country = Util.getFaker().country().name();
                        fluxSink.next(country);
                    } while (!country.equalsIgnoreCase("canada"));

                    fluxSink.complete();
                })
                .subscribe(Util.subscriber("sub3"));

    }

}

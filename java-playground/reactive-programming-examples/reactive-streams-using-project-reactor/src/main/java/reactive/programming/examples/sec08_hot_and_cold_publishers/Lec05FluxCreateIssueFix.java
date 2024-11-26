package reactive.programming.examples.sec08_hot_and_cold_publishers;

import reactive.programming.examples.sec04flux_emitting_items_programmatically.helper.NameGenerator;
import reactive.programming.examples.utilities.Util;
import reactor.core.publisher.Flux;

/*
    To fix the issue we faced in reactive.programming.examples.sec04flux_emitting_items_programmatically/Lec02FluxCreateRefactor

    Lec02FluxCreateRefactor is not going to work for multiple subscribers.
    Why?
    As soon as "flux.subscribe()" is done for a new publisher, the old one is forgotten - or the events from the old publisher are not received anymore.
 */
public class Lec05FluxCreateIssueFix {

    public static void main(String[] args) {

        NameGenerator generator = new NameGenerator();
        var flux = Flux.create(generator).share();
        flux.subscribe(Util.subscriber("sub1"));
        flux.subscribe(Util.subscriber("sub2"));

        // somewhere else!
        for (int i = 0; i < 10; i++) {
            generator.generate();
        }

    }

}

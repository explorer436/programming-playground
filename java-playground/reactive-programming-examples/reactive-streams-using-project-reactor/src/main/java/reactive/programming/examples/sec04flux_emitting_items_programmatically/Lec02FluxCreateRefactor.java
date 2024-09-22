package reactive.programming.examples.sec04flux_emitting_items_programmatically;

import reactive.programming.examples.sec04flux_emitting_items_programmatically.helper.NameGenerator;
import reactive.programming.examples.utilities.Util;
import reactor.core.publisher.Flux;

public class Lec02FluxCreateRefactor {

    public static void main(String[] args) {

        NameGenerator nameGenerator = new NameGenerator();
        Flux<String> flux = Flux.create(nameGenerator);
        flux.subscribe(Util.subscriber("sub1"));

        // Use the class somewhere else in the code - where it is necessary
        for (int i = 0; i < 10; i++) {
            nameGenerator.generate();
        }

    }

}

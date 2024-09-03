package reactive.programming.examples.flux_emitting_items_programmatically;

import lombok.extern.slf4j.Slf4j;
import reactive.programming.examples.util.Util;
import reactor.core.publisher.Flux;

/**
 * Flux generate
 * - invokes the given lambda expression again and again based on downstream demand.
 * - We can emit only one value at a time
 * - will stop when complete method is invoked
 * - will stop when error method is invoked
 * - will stop downstream cancels
 */
@Slf4j
public class Lec06FluxGenerate {

    public static void main(String[] args) {

        synchronousSink();

    }

    private static void synchronousSink() {
        Flux.generate(synchronousSink -> {
                    log.info("invoked");
                    synchronousSink.next(1);
                    // synchronousSink.next(2); // cannot emit more than one item.

                    // We can emit complete or error signals
                    // synchronousSink.complete();
                    // synchronousSink.error(new RuntimeException("oops"));
                })
                .take(4)
                .subscribe(Util.subscriber());
    }

}

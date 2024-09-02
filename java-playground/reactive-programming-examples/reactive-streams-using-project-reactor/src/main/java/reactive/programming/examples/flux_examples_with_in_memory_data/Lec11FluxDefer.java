package reactive.programming.examples.flux_examples_with_in_memory_data;

import lombok.extern.slf4j.Slf4j;
import reactive.programming.examples.util.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Slf4j
public class Lec11FluxDefer {
    public static void main(String[] args) {

        // The publisher is created but not subscribed to. So nothing will happen.
        createPublisher();

        // Even the publisher is not created.
        Flux.defer(Lec11FluxDefer::createPublisher);
    }

    public static Flux createPublisher() {

        log.info(">>> createPublisher()");

        Flux<String> f = Flux.interval(Duration.ofMillis(500))
                .map(i -> Util.getFaker().name().firstName());

        return f;

    }
}

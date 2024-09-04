package reactive.programming.examples.operators;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class Lec05Subscribe {

    public static void main(String[] args) {

        Flux.range(1, 10)
                .doOnNext(i -> log.info("received: {}", i))
                .doOnComplete(() -> log.info("completed"))
                .doOnError(err -> log.error("error", err))
                .subscribe();

        // Instead of implementing the subscriber interface and using that class in the "subscribe()" method,
        // we an use the operators to define that behavior.
        // This improves readability.


    }

}

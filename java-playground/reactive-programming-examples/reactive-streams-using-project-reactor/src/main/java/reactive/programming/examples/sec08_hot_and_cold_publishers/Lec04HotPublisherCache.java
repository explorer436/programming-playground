package reactive.programming.examples.sec08_hot_and_cold_publishers;

import lombok.extern.slf4j.Slf4j;
import reactive.programming.examples.utilities.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

/*
    - publish().autoConnect(0) will provide new values to the subscribers.
    - replay allows us to cache
 */
@Slf4j
public class Lec04HotPublisherCache {

    public static void main(String[] args) {

        // replay instead of publish
        var stockFlux = stockStream().replay(1).autoConnect(0);

        Util.sleepSeconds(4);

        log.info("sam joining");
        stockFlux
                .subscribe(Util.subscriber("sam"));

        Util.sleepSeconds(4);

        log.info("mike joining");
        stockFlux
                .subscribe(Util.subscriber("mike"));

        Util.sleepSeconds(15);

    }

    private static Flux<Integer> stockStream() {
        return Flux.generate(sink -> sink.next(Util.getFaker().random().nextInt(10, 100)))
                   .delayElements(Duration.ofSeconds(3))
                   .doOnNext(price -> log.info("emitting price: {}", price))
                   .cast(Integer.class);
    }

}

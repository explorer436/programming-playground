package reactive.programming.examples.sec08_hot_and_cold_publishers;

import lombok.extern.slf4j.Slf4j;
import reactive.programming.examples.utilities.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

/*
    Hot - 1 data producer for all the subscribers.
    share => publish().refCount(1)
    It needs 1 min subscriber to emit data.
    It stops when there is 0 subscriber.
    Re-subscription - It starts again where there is a new subscriber.
    To have min 2 subscribers, use publish().refCount(2);
 */
@Slf4j
public class Lec02HotPublisher {

    public static void main(String[] args) {

        demo1();
        log.info("------------");
        demo2();
        log.info("------------");
        demo3();
        log.info("------------");
        demo4();
    }

    // cold publisher
    private static void demo1() {

        log.info("demo 1");

        var movieFlux = movieStream();

        Util.sleepSeconds(2);

        movieFlux
                .take(4)
                .subscribe(Util.subscriber("sam"));

        Util.sleepSeconds(3);

        movieFlux
                .take(3)
                .subscribe(Util.subscriber("mike"));

        Util.sleepSeconds(15);
    }

    // hot publisher
    // .share() does it.
    private static void demo2() {

        log.info("demo 2");

        var movieFlux = movieStream().share();

        Util.sleepSeconds(2);

        movieFlux
                .take(4)
                .subscribe(Util.subscriber("sam"));

        Util.sleepSeconds(3);

        movieFlux
                .take(3)
                .subscribe(Util.subscriber("mike"));

        Util.sleepSeconds(15);
    }

    // hot publisher
    // .share() does it.
    private static void demo3() {

        log.info("demo 3");

        var movieFlux = movieStream().share();

        Util.sleepSeconds(2);

        movieFlux
                .take(1)
                .subscribe(Util.subscriber("sam"));

        Util.sleepSeconds(3);

        // re-subscription
        // Since the publishing stops by the time mike joins - it will start at 1 again.
        movieFlux
                .take(3)
                .subscribe(Util.subscriber("mike"));

        Util.sleepSeconds(15);
    }

    // hot publisher
    // wait for the specified number of subscribers - don't publish before that.
    // .refCount() does it.
    private static void demo4() {

        log.info("demo 4");

        var movieFlux = movieStream().publish().refCount(2);

        Util.sleepSeconds(2);

        movieFlux
                .take(4)
                .subscribe(Util.subscriber("sam"));

        Util.sleepSeconds(3);

        movieFlux
                .take(3)
                .subscribe(Util.subscriber("mike"));

        Util.sleepSeconds(15);
    }

    // movie theater
    private static Flux<String> movieStream() {
        return Flux.generate(
                           () -> {
                               log.info("received the request");
                               return 1;
                           },
                           (state, sink) -> {
                               String scene = "movie scene " + state;
                               log.info("playing {}", scene);
                               sink.next(scene);
                               return ++state;
                           }
                   )
                   .take(10)
                   .delayElements(Duration.ofSeconds(1))
                   .cast(String.class);
    }

}

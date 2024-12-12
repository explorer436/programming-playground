package reactive.programming.examples.sec09_threading_and_schedulers;

import lombok.extern.slf4j.Slf4j;
import reactive.programming.examples.utilities.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

/*
    We can have multiple subscribeOn.
    The closest to the source will take the precedence!
 */
@Slf4j
public class Lec03MultipleSubscribeOn {

    public static void main(String[] args) {

        var flux = Flux.create(sink -> {
                           for (int i = 1; i < 3; i++) {
                               log.info("generating: {}", i);
                               sink.next(i);
                           }
                           sink.complete();
                       })
                       .subscribeOn(Schedulers.newParallel("vins"))
                       .doOnNext(v -> log.info("value: {}", v))
                       .doFirst(() -> log.info("first1"))
                       .subscribeOn(Schedulers.boundedElastic())
                       .doFirst(() -> log.info("first2"));

        Runnable runnable1 = () -> flux.subscribe(Util.subscriber("sub1"));

        Thread.ofPlatform().start(runnable1);

        Util.sleepSeconds(2);
    }

}

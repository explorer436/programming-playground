package reactive.programming.examples.sec09_threading_and_schedulers;

import lombok.extern.slf4j.Slf4j;
import reactive.programming.examples.utilities.Util;
import reactor.core.publisher.Flux;

/*
    By default, the current thread is doing all the work
 */
@Slf4j
public class Lec01DefaultBehaviorDemo {

    public static void main(String[] args) {

        extracted1();

        log.info("------------");

        extracted2();

    }

    private static void extracted1() {
        var flux = Flux.create(sink -> {
                    for (int i = 1; i < 3; i++) {
                        log.info("generating: {}", i);
                        sink.next(i);
                    }
                    sink.complete();
                })
                .doOnNext(v -> log.info("value: {}", v));

        flux.subscribe(Util.subscriber("sub1"));
        flux.subscribe(Util.subscriber("sub2"));
    }

    private static void extracted2() {
        var flux = Flux.create(sink -> {
                           for (int i = 1; i < 3; i++) {
                               log.info("generating: {}", i);
                               sink.next(i);
                           }
                           sink.complete();
                       })
                       .doOnNext(v -> log.info("value: {}", v));

        Runnable runnable1 = () -> flux.subscribe(Util.subscriber("sub1"));
        Thread.ofPlatform().start(runnable1);

        Runnable runnable2 = () -> flux.subscribe(Util.subscriber("sub2"));
        Thread.ofPlatform().start(runnable2);
    }

}

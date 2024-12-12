package reactive.programming.examples.sec09_threading_and_schedulers;

import lombok.extern.slf4j.Slf4j;
import reactive.programming.examples.utilities.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

@Slf4j
public class Lec02SubscribeOn {

    public static void main(String[] args) {

        extracted1();

        log.info("-----------------");

        extracted2();

        log.info("-----------------");

        extracted3();

        log.info("-----------------");

        extracted5();

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

        flux
                .doFirst(() -> log.info("first1"))
                .doFirst(() -> log.info("first2"))
                .subscribe(Util.subscriber("sub1"));

        Util.sleepSeconds(2);
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

        flux
                .doFirst(() -> log.info("first1"))
                .subscribeOn(Schedulers.boundedElastic())
                .doFirst(() -> log.info("first2"))
                .subscribe(Util.subscriber("sub1"));

        Util.sleepSeconds(2);
    }

    private static void extracted3() {
        var flux = Flux.create(sink -> {
                    for (int i = 1; i < 3; i++) {
                        log.info("generating: {}", i);
                        sink.next(i);
                    }
                    sink.complete();
                })
                .doOnNext(v -> log.info("value: {}", v));

        Runnable runnable = () -> flux
                .doFirst(() -> log.info("first1"))
                .subscribeOn(Schedulers.boundedElastic())
                .doFirst(() -> log.info("first2"))
                .subscribe(Util.subscriber("sub1"));

        Thread.ofPlatform().start(runnable);

        Util.sleepSeconds(2);
    }

    // same as extracted3
    private static void extracted4() {
        var flux = Flux.create(sink -> {
                    for (int i = 1; i < 3; i++) {
                        log.info("generating: {}", i);
                        sink.next(i);
                    }
                    sink.complete();
                })
                .doOnNext(v -> log.info("value: {}", v))
                .doFirst(() -> log.info("first1"))
                .subscribeOn(Schedulers.boundedElastic())
                .doFirst(() -> log.info("first2"));

        Runnable runnable = () -> flux.subscribe(Util.subscriber("sub1"));

        Thread.ofPlatform().start(runnable);

        Util.sleepSeconds(2);
    }

    private static void extracted5() {
        var flux = Flux.create(sink -> {
                    for (int i = 1; i < 3; i++) {
                        log.info("generating: {}", i);
                        sink.next(i);
                    }
                    sink.complete();
                })
                .doOnNext(v -> log.info("value: {}", v))
                .doFirst(() -> log.info("first1"))
                .subscribeOn(Schedulers.boundedElastic())
                .doFirst(() -> log.info("first2"));


        Runnable runnable1 = () -> flux.subscribe(Util.subscriber("sub1"));
        Runnable runnable2 = () -> flux.subscribe(Util.subscriber("sub2"));

        Thread.ofPlatform().start(runnable1);
        Thread.ofPlatform().start(runnable2);

        Util.sleepSeconds(2);
    }

}

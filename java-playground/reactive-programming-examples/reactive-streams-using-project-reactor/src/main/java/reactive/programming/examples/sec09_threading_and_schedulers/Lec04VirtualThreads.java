package reactive.programming.examples.sec09_threading_and_schedulers;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactive.programming.examples.utilities.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

/*
    reactor supports virtual threads
    System.setProperty("reactor.schedulers.defaultBoundedElasticOnVirtualThreads", "true");
 */
@Slf4j
public class Lec04VirtualThreads {

    public static void main(String[] args) {

        System.setProperty("reactor.schedulers.defaultBoundedElasticOnVirtualThreads", "true");

        var flux = Flux.create(sink -> {
                           for (int i = 1; i < 3; i++) {
                               log.info("generating: {}", i);
                               sink.next(i);
                           }
                           sink.complete();
                       })
                       .doOnNext(v -> log.info("value: {}", v))
                       .doFirst(() -> log.info("first1-{}", Thread.currentThread().isVirtual()))
                       .subscribeOn(Schedulers.boundedElastic())
                       .doFirst(() -> log.info("first2"));


        Runnable runnable1 = () -> flux.subscribe(Util.subscriber("sub1"));

        Thread.ofPlatform().start(runnable1);

        Util.sleepSeconds(2);

    }

}

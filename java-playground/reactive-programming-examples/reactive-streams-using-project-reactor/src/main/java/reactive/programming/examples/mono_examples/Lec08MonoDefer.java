package reactive.programming.examples.mono_examples;

import lombok.extern.slf4j.Slf4j;
import reactive.programming.examples.util.Util;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
public class Lec08MonoDefer {

    public static void main(String[] args) {

        // getName().subscribe(Util.subscriber());
        getName();
        /*
            Unless we subscribe to the Publisher, the Supplier is not executed.
            The flow will go into getName() - the entry log is printed.
            But the Mono is not executed until someone subscribes to it.
         */

        // What if we don't want to get into the method either?

        // Mono.defer(MonoDefer::createPublisher).subscribe(Util.subscriber());
        Mono.defer(Lec08MonoDefer::createPublisher);
        // defer() accepts the Supplier of Mono
        // Using this, we can delay the creation of the Publisher itself - not just the execution of the Publisher.

        // as opposed to
        // createPublisher();
    }

    private static Mono<String> getName() {
        log.info(">>> getName()");
        return Mono.fromSupplier(() -> {
            log.info("generating name");
            Util.sleepSeconds(3);
            return Util.getFaker().name().firstName();
        });
    }

    // time-consuming publisher creation
    private static Mono<Integer> createPublisher() {
        log.info(">>> createPublisher()");
        List<Integer> list = List.of(1, 2, 3);
        Util.sleepSeconds(3);
        return Mono.fromSupplier(() -> sum(list));
    }

    // time-consuming business logic
    private static int sum(List<Integer> list) {
        log.info("finding the sum of {}", list);
        Util.sleepSeconds(3);
        return list.stream().mapToInt(a -> a).sum();
    }

}


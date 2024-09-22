package reactive.programming.examples.sec02mono_examples;

import lombok.extern.slf4j.Slf4j;
import reactive.programming.examples.utilities.Util;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 *  To delay the execution using supplier / callable / runnable
 */
@Slf4j
public class Lec04MonoFromSupplier {

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3);

        log.info("18");
        // The sum() will run until here for supplier1 - even though we are not calling the ".subscribe()" method on it yet.
        Mono<Integer> supplier1 = Mono.just(sum(list));
        log.info("21");

        // delay the execution until it is absolutely necessary
        Mono<Integer> supplier2 = Mono.fromSupplier(() -> sum(list));
        log.info("25");

        log.info("27");
        supplier1.subscribe(Util.subscriber());
        log.info("29");

        log.info("31");
        // The sum() will not run until here for supplier2
        supplier2.subscribe(Util.subscriber());
        log.info("34");

        /*
           Mono.justSupplier() replaces Mono.just()
         */
    }

    /*
        simulating a compute intensive operation
     */
    private static int sum(List<Integer> list) {
        log.info("finding the sum of {}", list);
        return list.stream().mapToInt(a -> a).sum();
    }

}

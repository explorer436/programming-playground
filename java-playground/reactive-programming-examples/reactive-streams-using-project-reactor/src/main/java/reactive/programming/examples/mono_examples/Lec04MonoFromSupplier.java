package reactive.programming.examples.mono_examples;

import lombok.extern.slf4j.Slf4j;
import reactive.programming.examples.util.Util;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 *  To delay the execution using supplier / callable / runnable
 */
@Slf4j
public class Lec04MonoFromSupplier {

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3);

        // delay the execution until it is absolutely necessary

        Mono<Integer> supplier1 = Mono.just(sum(list));
        supplier1.subscribe(Util.subscriber());

        Mono<Integer> supplier2 = Mono.fromSupplier(() -> sum(list));
        supplier2.subscribe(Util.subscriber());

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

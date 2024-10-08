package reactive.programming.examples.sec02mono_examples;

import lombok.extern.slf4j.Slf4j;
import reactive.programming.examples.utilities.Util;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 *  To delay the execution using supplier / callable / runnable
 */
@Slf4j
public class Lec05MonoFromCallable {

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3);

        Mono<Integer> supplier1 = Mono.just(sum(list));
        supplier1.subscribe(Util.subscriber());

        // delay the execution until it is absolutely necessary
        Mono<Integer> supplier2 = Mono.fromCallable(() -> sum(list));
        supplier2.subscribe(Util.subscriber());
    }

    /*
        simulating a compute intensive operation
     */
    private static int sum(List<Integer> list) {
        log.info("finding the sum of {}", list);
        return list.stream().mapToInt(a -> a).sum();
    }

}

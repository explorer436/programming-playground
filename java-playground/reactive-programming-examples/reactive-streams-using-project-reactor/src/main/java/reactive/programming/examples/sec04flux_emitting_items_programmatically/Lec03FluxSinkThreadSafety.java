package reactive.programming.examples.sec04flux_emitting_items_programmatically;

import lombok.extern.slf4j.Slf4j;
import reactive.programming.examples.sec04flux_emitting_items_programmatically.helper.NameGenerator;
import reactive.programming.examples.utilities.Util;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.ArrayList;

/**
    FluxSink is thread safe!
    This is just a demo.
    It does NOT mean we should write code like this!
 */
@Slf4j
public class Lec03FluxSinkThreadSafety {

    public static void main(String[] args) {

        // demo1();
        demo2();

    }

    // arraylist is not thread safe
    private static void demo1(){
        List<Integer> list = new ArrayList<Integer>();
        Runnable runnable = () -> {
            for (int i = 0; i < 1000; i++) {
                list.add(i);
            }
        };
        for (int i = 0; i < 10; i++) {
            Thread.ofPlatform().start(runnable);
        }
        Util.sleepSeconds(3);
        log.info("list size: {}", list.size());

        // expected is 10,000 but the actual value is less than that.
    }

    // arraylist is not thread safe.
    // flux sink is thread safe. we get all the 10000 items safely into array list.
    private static void demo2(){
        ArrayList<String> list = new ArrayList<String>();
        NameGenerator nameGenerator = new NameGenerator();
        Flux<String> flux = Flux.create(nameGenerator);
        flux.subscribe(list::add);

        Runnable runnable = () -> {
            for (int i = 0; i < 1000; i++) {
                nameGenerator.generate();
            }
        };
        for (int i = 0; i < 10; i++) {
            Thread.ofPlatform().start(runnable);
        }
        Util.sleepSeconds(3);
        log.info("list size: {}", list.size());
        // 10,000
    }

}

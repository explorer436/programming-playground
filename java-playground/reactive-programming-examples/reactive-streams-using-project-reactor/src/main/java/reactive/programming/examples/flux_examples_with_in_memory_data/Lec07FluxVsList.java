package reactive.programming.examples.flux_examples_with_in_memory_data;

import lombok.extern.slf4j.Slf4j;
import reactive.programming.examples.custom_implementation_of_the_interfaces.subscriber.SubscriberImpl;
import reactive.programming.examples.util.Util;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.IntStream;

@Slf4j
public class Lec07FluxVsList {

    public static void main(String[] args) {

        SubscriberImpl subscriber = new SubscriberImpl();
        getNamesFlux(10).subscribe(subscriber);
        subscriber.getSubscription().request(5);
        subscriber.getSubscription().cancel();

        // 1. Sequential - blocked for 10 seconds.
        // 2. Cannot stop the flux at some point in the middle. We have to process the entire list.
        List<String> list = getNamesList(10);
        log.info(String.valueOf(list));
    }

    public static List<String> getNamesList(int count){
        return IntStream.rangeClosed(1, count)
                .mapToObj(i -> generateName())
                .toList();
    }

    public static Flux<String> getNamesFlux(int count){
        return Flux.range(1, count)
                .map(i -> generateName());
    }

    private static String generateName(){
        Util.sleepSeconds(1);
        return Util.getFaker().name().firstName();
    }

}

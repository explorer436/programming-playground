package reactive.programming.examples.sec06operators;

import reactive.programming.examples.utilities.Util;
import reactor.core.publisher.Flux;

/**

   https://projectreactor.io/docs/core/release/api/reactor/core/publisher/Flux.html#handle-java.util.function.BiConsumer-

    Handle behaves like filter + map

    1 => -2
    4 => do not send
    7 => error
    everything else => send as it is
*/
public class Lec01Handle {

    public static void main(String[] args) {

        Flux.range(1, 10)
                .cast(Integer.class)
                .subscribe(Util.subscriber());

       Flux.range(1, 10)
               .handle((item, synchronousSink) -> {
                   switch (item){
                       case 1 -> synchronousSink.next(-2);
                       case 4 -> {}
                       // case 7 -> synchronousSink.error(new RuntimeException("oops"));
                       default -> synchronousSink.next(item);
                   }
               })
               .cast(Integer.class)
               .subscribe(Util.subscriber());
    }

}

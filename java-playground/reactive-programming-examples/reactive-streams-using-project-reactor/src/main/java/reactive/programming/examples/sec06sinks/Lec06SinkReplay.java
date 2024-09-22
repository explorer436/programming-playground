package reactive.programming.examples.sec06sinks;

import reactive.programming.examples.utilities.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class Lec06SinkReplay {

    /*
        11:31:47.795 INFO  [           main] r.p.e.u.DefaultSubscriber      : sam received: hi
        11:31:47.799 INFO  [           main] r.p.e.u.DefaultSubscriber      : sam received: how are you
        11:31:47.799 INFO  [           main] r.p.e.u.DefaultSubscriber      : mike received: hi
        11:31:47.799 INFO  [           main] r.p.e.u.DefaultSubscriber      : mike received: how are you
        11:31:47.799 INFO  [           main] r.p.e.u.DefaultSubscriber      : sam received: ?
        11:31:47.799 INFO  [           main] r.p.e.u.DefaultSubscriber      : mike received: ?
        11:31:47.799 INFO  [           main] r.p.e.u.DefaultSubscriber      : jake received: hi
        11:31:47.799 INFO  [           main] r.p.e.u.DefaultSubscriber      : jake received: how are you
        11:31:47.799 INFO  [           main] r.p.e.u.DefaultSubscriber      : jake received: ?
        11:31:47.799 INFO  [           main] r.p.e.u.DefaultSubscriber      : sam received: new msg
        11:31:47.799 INFO  [           main] r.p.e.u.DefaultSubscriber      : mike received: new msg
        11:31:47.799 INFO  [           main] r.p.e.u.DefaultSubscriber      : jake received: new msg
     */

    public static void main(String[] args) {

        // handle through which we would push items
        Sinks.Many<Object> sink = Sinks.many().replay().all();

        // handle through which subscribers will receive items
        Flux<Object> flux = sink.asFlux();

        sink.tryEmitNext("hi");
        sink.tryEmitNext("how are you");

        flux.subscribe(Util.subscriber("sam"));
        flux.subscribe(Util.subscriber("mike"));

        sink.tryEmitNext("?");

        flux.subscribe(Util.subscriber("jake"));

        sink.tryEmitNext("new msg");

    }

}

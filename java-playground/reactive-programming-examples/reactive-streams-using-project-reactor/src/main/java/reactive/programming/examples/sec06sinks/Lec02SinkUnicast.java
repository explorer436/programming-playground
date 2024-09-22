package reactive.programming.examples.sec06sinks;

import reactive.programming.examples.utilities.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class Lec02SinkUnicast {
    public static void main(String[] args) {

        // handle through which we would push items
        Sinks.Many<Object> sink = Sinks.many().unicast().onBackpressureBuffer();

        // handle through which subscribers will receive items
        Flux<Object> flux = sink.asFlux();

        flux.subscribe(Util.subscriber("sam"));

        /*
           java.lang.IllegalStateException: Sinks.many().unicast() sinks only allow a single Subscriber
                at reactor.core.publisher.SinkManyUnicast.subscribe(SinkManyUnicast.java:426)
                at reactor.core.publisher.Flux.subscribe(Flux.java:8840)
                at reactive.programming.examples.sec06sinks.Lec02SinkUnicast.main(Lec02SinkUnicast.java:17)
         */
        flux.subscribe(Util.subscriber("mike"));

        sink.tryEmitNext("hi");
        sink.tryEmitNext("how are you");
        sink.tryEmitNext("?");

        sink.tryEmitNext("hello");
        sink.tryEmitNext("howlly");
        sink.tryEmitNext("Neha");
    }
}

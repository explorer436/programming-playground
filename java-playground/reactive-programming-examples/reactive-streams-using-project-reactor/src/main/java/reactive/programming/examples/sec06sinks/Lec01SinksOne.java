package reactive.programming.examples.sec06sinks;

import reactive.programming.examples.utilities.Util;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

public class Lec01SinksOne {
    public static void main(String[] args) {

        Sinks.One<Object> sink = Sinks.one();
        sink.tryEmitValue("Hello");
        sink.tryEmitValue("Hi");

        Mono<Object> mono = sink.asMono();

        mono.subscribe(Util.subscriber("Sam"));
        mono.subscribe(Util.subscriber("Mike"));

    }
}

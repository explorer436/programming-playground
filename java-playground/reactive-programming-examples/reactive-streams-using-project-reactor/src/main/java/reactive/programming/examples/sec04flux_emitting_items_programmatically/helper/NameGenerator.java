package reactive.programming.examples.sec04flux_emitting_items_programmatically.helper;

import reactive.programming.examples.utilities.Util;
import reactor.core.publisher.FluxSink;

import java.util.function.Consumer;

public class NameGenerator implements Consumer<FluxSink<String>> {

    private FluxSink<String> sink;

    @Override
    public void accept(FluxSink<String> stringFluxSink) {
        this.sink = stringFluxSink;
    }

    public void generate(){
        this.sink.next(Util.getFaker().name().firstName());
    }

}

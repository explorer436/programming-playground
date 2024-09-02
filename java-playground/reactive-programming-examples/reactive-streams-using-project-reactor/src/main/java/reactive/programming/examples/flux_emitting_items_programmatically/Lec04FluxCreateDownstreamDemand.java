package reactive.programming.examples.flux_emitting_items_programmatically;

import lombok.extern.slf4j.Slf4j;
import reactive.programming.examples.custom_implementation_of_the_interfaces.subscriber.SubscriberImpl;
import reactive.programming.examples.util.Util;
import reactor.core.publisher.Flux;

/**
    Flux create does NOT check the downstream demand by default! It is by design!
 */
@Slf4j
public class Lec04FluxCreateDownstreamDemand {

    public static void main(String[] args) {

        // produceEarly();
        produceOnDemand();

    }

    private static void produceEarly(){
        SubscriberImpl subscriber = new SubscriberImpl();

        Flux.<String>create(fluxSink -> {
            // The Publisher does all the work regardless of whether anyone subscribes it or not.
            for (int i = 0; i < 10; i++) {
                String name = Util.getFaker().name().firstName();
                log.info("generated: {}", name);
                fluxSink.next(name);
            }
            fluxSink.complete();
        }).subscribe(subscriber);

        Util.sleepSeconds(2);

        subscriber.getSubscription().request(2);
        Util.sleepSeconds(2);

        subscriber.getSubscription().request(2);
        Util.sleepSeconds(2);

        subscriber.getSubscription().cancel();
        subscriber.getSubscription().request(2);
    }

    private static void produceOnDemand(){
        SubscriberImpl subscriber = new SubscriberImpl();
        Flux.<String>create(fluxSink -> {

            // The Publisher does not do all the work upfront.
            // It will emit items only when a subscriber requests items.
            
            fluxSink.onRequest(request -> {
                for (int i = 0; i < request && !fluxSink.isCancelled(); i++) {
                    String name = Util.getFaker().name().firstName();
                    log.info("generated: {}", name);
                    fluxSink.next(name);
                }
            });

        }).subscribe(subscriber);
        
        Util.sleepSeconds(2);

        subscriber.getSubscription().request(2);
        Util.sleepSeconds(2);

        subscriber.getSubscription().request(2);
        Util.sleepSeconds(2);

        subscriber.getSubscription().cancel();
        subscriber.getSubscription().request(2);
    }

}

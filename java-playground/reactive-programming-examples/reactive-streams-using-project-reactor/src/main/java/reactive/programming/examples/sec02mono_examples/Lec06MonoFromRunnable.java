package reactive.programming.examples.sec02mono_examples;

import lombok.extern.slf4j.Slf4j;
import reactive.programming.examples.utilities.Util;
import reactor.core.publisher.Mono;

/**
 *  To delay the execution using supplier / callable / runnable
 */
@Slf4j
public class Lec06MonoFromRunnable {

    public static void main(String[] args) {
        getProductName(2)
                .subscribe(Util.subscriber());
    }

    private static Mono<String> getProductName(int productId){
        if(productId == 1){
            return Mono.fromSupplier(() -> Util.getFaker().commerce().productName());
        }

        /*
           Similar to how Mono.justSupplier() replaces Mono.just(), Mono.fromRunnable() handles Mono.empty() scenarios.
           Used to perform additional functionality before emitting Mono.empty()
        */

        // return Mono.empty();
        return Mono.fromRunnable(() -> notifyBusiness(productId));
    }

    private static void notifyBusiness(int productId){
        log.info("notifying business on unavailable product {}", productId);
    }

}

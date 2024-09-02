package reactive.programming.examples.mono_examples;

import lombok.extern.slf4j.Slf4j;
import reactive.programming.examples.util.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

/**
 * If we have a CompletableFuture already, then we can convert that into a Mono
 */
@Slf4j
public class Lec07MonoFromFuture {
    public static void main(String[] args) {

        Mono.fromFuture(getName()).subscribe(Util.subscriber());

        /**
         * By default, CompletableFuture is not lazy.
         * The reactor library lets us make it a Supplier of CompletableFuture.
         */
        Mono.fromFuture(Lec07MonoFromFuture::getName).subscribe(Util.subscriber());

        Util.sleepSeconds(1);
    }

    private static CompletableFuture<String> getName(){
        return CompletableFuture.supplyAsync(() -> {
            log.info("generating name");
            return Util.getFaker().name().firstName();
        });
    }
}

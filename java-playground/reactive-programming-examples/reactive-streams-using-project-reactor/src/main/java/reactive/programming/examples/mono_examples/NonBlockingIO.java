package reactive.programming.examples.mono_examples;

import lombok.extern.slf4j.Slf4j;
import reactive.programming.examples.client.ExternalServiceClient;
import reactive.programming.examples.util.Util;

/**
 * Uses reactor-netty to send http requests to external services.
 * Uses reactor-netty-core and reactor-netty-http from pom.xml
 * These are the same libraries used by spring webflux as well.
 *
 *  Why should we use reactor-netty instead of writing asynchronous non-blocking java client ourselves?
 *  We can write the client ourselves - implement a lot of callbacks.
 *  It is very difficult.
 */
@Slf4j
public class NonBlockingIO {
    public static void main(String[] args) {

        ExternalServiceClient client = new ExternalServiceClient();

        log.info("starting");

        // This is done in a non-blocking way. So, the entire loop is done in less than a second.
        for (int i = 1; i <= 100; i++) {
            client.getProductName(i).subscribe(Util.subscriber());
            /*
               Notice that the sequence is not preserved.
               The non-blocking call does not wait for the responses in sequence.
             */
        }

        // blocking
        // sequence is preserved
        // very slow and blocking the main thread
        // Do not use blocking in reactive programming.
        /*for (int i = 1; i <= 100; i++) {
            String abc = client.getProductName(i).block();
            log.info(abc);
        }*/

        // To block the main thread
        Util.sleepSeconds(2);
    }
}

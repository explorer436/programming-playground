package reactive.programming.examples;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

/*
    To write a simple test using StepVerifier.
    StepVerifier acts like a subscriber.
 */
@Slf4j
public class Lec01MonoTest {

    // assume this a method from your service class
    private Mono<String> getProduct(int id) {
        return Mono.fromSupplier(() -> "product-" + id)
                   .doFirst(() -> log.info("invoked"));
    }

    @Test
    public void productTest(){
        StepVerifier.create(getProduct(1))
                .expectNext("product-1")
                .expectComplete()
                .verify(); // subscribe
    }

}

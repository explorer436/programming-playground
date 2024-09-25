package reactive.programming.examples;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.Duration;

public class Lec11CombiningPublishers {

    private static Integer min = 1;
    private static Integer max = 5;

    Flux<Integer> evenNumbers = Flux
            .range(min, max)
            .filter(x -> x % 2 == 0); // i.e. 2, 4

    Flux<Integer> oddNumbers = Flux
            .range(min, max)
            .filter(x -> x % 2 > 0);  // ie. 1, 3, 5

    /*
        The concat method executes a concatenation of the inputs, forwarding elements emitted by the sources downstream.

        The concatenation is achieved by sequentially subscribing to the first source then waiting for it to complete before subscribing to the next, and so on until the last source completes. Any error interrupts the sequence immediately and is forwarded downstream.
     */

    @Test
    public void test_concat() {
        Flux<Integer> fluxOfIntegers = Flux.concat(
                evenNumbers,
                oddNumbers);

        StepVerifier.create(fluxOfIntegers)
                .expectNext(2)
                .expectNext(4)
                .expectNext(1)
                .expectNext(3)
                .expectNext(5)
                .expectComplete()
                .verify();
    }

    /*
        Using the static method concatWith, we’ll produce a concatenation of two sources of type Flux<T> as a result.
     */

    @Test
    public void test_concatWith() {
        Flux<Integer> fluxOfIntegers = evenNumbers.concatWith(oddNumbers);

        // same stepVerifier as in the concat example above

        StepVerifier.create(fluxOfIntegers)
                .expectNext(2)
                .expectNext(4)
                .expectNext(1)
                .expectNext(3)
                .expectNext(5)
                .expectComplete()
                .verify();
    }

    /*
        The Flux static method combineLatest will generate data provided by the combination of the most recently published value from each of the Publisher sources.

        Here’s an example of the usage of this method with two Publisher sources and a BiFunction as parameters.
     */

    @Test
    public void test_combineLatest() {
        Flux<Integer> fluxOfIntegers = Flux.combineLatest(
                evenNumbers,
                oddNumbers,
                (a, b) -> a + b);

        StepVerifier.create(fluxOfIntegers)
                .expectNext(5) // 4 + 1
                .expectNext(7) // 4 + 3
                .expectNext(9) // 4 + 5
                .expectComplete()
                .verify();
    }

    /*
        The merge function executes a merging of the data from Publisher sequences contained in an array into an interleaved merged sequence.
     */

    @Test
    public void test_merge() {
        Flux<Integer> fluxOfIntegers = Flux.merge(
                evenNumbers,
                oddNumbers);

        StepVerifier.create(fluxOfIntegers)
                .expectNext(2)
                .expectNext(4)
                .expectNext(1)
                .expectNext(3)
                .expectNext(5)
                .expectComplete()
                .verify();
    }

    /*
        As opposed to concat (lazy subscription), the sources are subscribed eagerly.

        Here, we can see a different outcome of the merge function if we insert a delay between the elements of the Publishers:
     */

    @Test
    public void test_mergeWithDelayedElements() {
        Flux<Integer> fluxOfIntegers = Flux.merge(
                evenNumbers.delayElements(Duration.ofMillis(500L)),
                oddNumbers.delayElements(Duration.ofMillis(300L)));

        StepVerifier.create(fluxOfIntegers)
                .expectNext(1)
                .expectNext(2)
                .expectNext(3)
                .expectNext(5)
                .expectNext(4)
                .expectComplete()
                .verify();
    }

    /*
        The mergeSequential method merges data from Publisher sequences provided in an array into an ordered merged sequence.

        Unlike concat, sources are subscribed to eagerly.

        Also, unlike merge, their emitted values are merged into the final sequence in subscription order
     */

    @Test
    public void test_mergeSequential() {
        Flux<Integer> fluxOfIntegers = Flux.mergeSequential(
                evenNumbers,
                oddNumbers);

        StepVerifier.create(fluxOfIntegers)
                .expectNext(2)
                .expectNext(4)
                .expectNext(1)
                .expectNext(3)
                .expectNext(5)
                .expectComplete()
                .verify();
    }

    /*
        The mergeDelayError merges data from Publisher sequences contained in an array into an interleaved merged sequence.

        Unlike concat, sources are subscribed to eagerly.

        This variant of the static merge method will delay any error until after the rest of the merge backlog has been processed.
     */

    @Test
    public void test_mergeDelayError() {
        Flux<Integer> fluxOfIntegers = Flux.mergeDelayError(1,
                evenNumbers.delayElements(Duration.ofMillis(500L)),
                oddNumbers.delayElements(Duration.ofMillis(300L)));

        StepVerifier.create(fluxOfIntegers)
                .expectNext(1)
                .expectNext(2)
                .expectNext(3)
                .expectNext(5)
                .expectNext(4)
                .expectComplete()
                .verify();
    }

    /*
        The static method mergeWith merges data from this Flux and a Publisher into an interleaved merged sequence.

        Again, unlike concat, inner sources are subscribed to eagerly.
     */

    @Test
    public void test_mergeWith() {
        Flux<Integer> fluxOfIntegers = evenNumbers.mergeWith(oddNumbers);

        // same StepVerifier as in "3.4. Merge"
        StepVerifier.create(fluxOfIntegers)
                .expectNext(2)
                .expectNext(4)
                .expectNext(1)
                .expectNext(3)
                .expectNext(5)
                .expectComplete()
                .verify();
    }

    /*
        The static method zip agglutinates multiple sources together, i.e., waits for all the sources to emit one element and combines these elements into an output value (constructed by the provided combinator function).

        The operator will continue doing so until any of the sources completes.
     */

    @Test
    public void test_zip() {
        Flux<Integer> fluxOfIntegers = Flux.zip(
                evenNumbers,
                oddNumbers,
                (a, b) -> a + b);

        StepVerifier.create(fluxOfIntegers)
                .expectNext(3) // 2 + 1
                .expectNext(7) // 4 + 3
                .expectComplete()
                .verify();
    }

    /*
        The zipWith executes the same method that zip does, but only with two Publishers:
     */

    @Test
    public void test_zipWith() {
        Flux<Integer> fluxOfIntegers = evenNumbers
                .zipWith(oddNumbers, (a, b) -> a * b);

        StepVerifier.create(fluxOfIntegers)
                .expectNext(2)  // 2 * 1
                .expectNext(12) // 4 * 3
                .expectComplete()
                .verify();
    }


}

package reactive.programming.examples;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactive.programming.examples.utilities.Util;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.Objects;

/*
    "assertNext" is a method in StepVerifier
    assertNext = consumeNextWith
    We can also collect all the items and test.
 */
public class Lec05AssertNextTest {

    record Book(int id, String author, String title) {
    }

    private Flux<Book> getBooks() {
        return Flux.range(1, 3)
                   .map(i -> new Book(i, Util.getFaker().book().author(), Util.getFaker().book().title()));
    }

    @Test
    public void assertNextTest() {
        StepVerifier.create(getBooks())
                    .assertNext(b -> Assertions.assertEquals(1, b.id()))
                    .thenConsumeWhile(b -> Objects.nonNull(b.title()))
                    .expectComplete()
                    .verify();
    }

    @Test
    public void collectAllAndTest() {
        StepVerifier.create(getBooks().collectList())
                    .assertNext(list -> Assertions.assertEquals(3, list.size()))
                    .expectComplete()
                    .verify();
    }

}

package reactive.programming.examples.mono_examples;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

/**
 * Emitting empty / error
 */
@Slf4j
public class Lec03EmitItemsBasedOnInput {
    public static void main(String[] args) {

        /*getUsername(3)
                .subscribe(Util.subscriber());*/

        // getUsername(3).subscribe(i -> log.info(i));
        // 07:43:14.389 [main] ERROR reactor.core.publisher.Operators -- Operator called default onErrorDropped
        // This means that, because we did not explicitly provide an error handler, reactive library is telling us that it is just dropping the error because it doesn't know what to do with it.

        getUsername(3)
                .subscribe(i -> log.info(i),
                        err -> {});

    }

    private static Mono<String> getUsername(int userId){
        return switch (userId){
            case 1 -> Mono.just("a-username");
            case 2 -> Mono.empty(); // null
            default -> Mono.error(new RuntimeException("invalid input"));
        };
    }
}

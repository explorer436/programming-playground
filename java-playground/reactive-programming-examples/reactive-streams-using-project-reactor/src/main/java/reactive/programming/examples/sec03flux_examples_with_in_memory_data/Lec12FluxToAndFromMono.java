package reactive.programming.examples.sec03flux_examples_with_in_memory_data;

import reactive.programming.examples.utilities.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/*
    To covert a Flux <--> Mono
 */
public class Lec12FluxToAndFromMono {

    public static void main(String[] args) {

        monoToFlux();
        fluxToMono();

    }

    private static void fluxToMono(){
        Flux<Integer> flux = Flux.range(1, 10);

        // option 1
        Mono<Integer> abc = flux.next();

        // option 2
        Mono.from(flux).subscribe(Util.subscriber());
    }

    private static void monoToFlux(){
        Mono<String> mono = getUsername(1);
        // We need to convert this mono to a Flux because save() expects a Flux.
        save(Flux.from(mono));
    }

    private static Mono<String> getUsername(int userId){
        return switch (userId){
            case 1 -> Mono.just("sam");
            case 2 -> Mono.empty(); // null
            default -> Mono.error(new RuntimeException("invalid input"));
        };
    }

    private static void save(Flux<String> flux){
        flux.subscribe(Util.subscriber());
    }

}

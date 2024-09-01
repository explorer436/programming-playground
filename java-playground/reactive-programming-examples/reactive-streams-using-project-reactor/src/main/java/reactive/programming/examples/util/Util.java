package reactive.programming.examples.util;

import com.github.javafaker.Faker;
import lombok.Getter;
import org.reactivestreams.Subscriber;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class Util {

    @Getter
    private static final Faker faker = Faker.instance();

    public static<T> Subscriber<T> subscriber() {
        return new DefaultSubscriber<>("");
    }

    public static<T> Subscriber<T> subscriber(String name) {
        return new DefaultSubscriber<>(name);
    }

    public static void main(String[] args) {
        Mono<Integer> mono = Mono.just(1);

        mono.subscribe(subscriber());
        mono.subscribe(subscriber("sub1"));
        mono.subscribe(subscriber("sub2"));
    }

    public static void sleepSeconds(int seconds){
        try {
            Thread.sleep(Duration.ofSeconds(seconds));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

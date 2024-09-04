package reactive.programming.examples.operators.assignment;

import reactive.programming.examples.client.AbstractHttpClient;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class ExternalServiceClient extends AbstractHttpClient {

    // Prerequisite: start external-services.jar with "java -jar external-services.jar"

    public Mono<String> getProductName(int productId) {

        var defaultPath = "/demo03/product/" + productId;
        var timeoutPath = "/demo03/timeout-fallback/product/" + productId;
        var emptyPath = "/demo03/empty-fallback/product/" + productId;

        return getProductName(defaultPath)
                .timeout(Duration.ofSeconds(2), getProductName(timeoutPath)) // call fallback function in timeout scenarios
                .switchIfEmpty(getProductName(emptyPath)); // call fallback function in empty response scenarios
    }

    private Mono<String> getProductName(String path) {
        return this.httpClient.get()
                              .uri(path)
                              .responseContent()
                              .asString()
                              .next();
    }

}

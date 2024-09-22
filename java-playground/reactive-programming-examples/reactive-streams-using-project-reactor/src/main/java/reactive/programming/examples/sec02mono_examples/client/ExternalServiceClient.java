package reactive.programming.examples.sec02mono_examples.client;

import reactive.programming.examples.utilities.client.AbstractHttpClient;
import reactor.core.publisher.Mono;

public class ExternalServiceClient extends AbstractHttpClient {

    // Prerequisite: start external-services.jar with "java -jar external-services.jar"

    // Functionality of the "external-services":
    // It takes an integer, there is a delay of 1 second, and it gives a product-name based on that integer.

    public Mono<String> getProductName(int productId) {
        return this.httpClient.get()
                .uri("/demo01/product/" + productId)
                .responseContent()
                .asString()
                .next();
    }

}
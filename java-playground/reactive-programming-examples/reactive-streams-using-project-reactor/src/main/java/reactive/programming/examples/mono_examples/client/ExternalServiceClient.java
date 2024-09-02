package reactive.programming.examples.mono_examples.client;

import reactive.programming.examples.client.AbstractHttpClient;
import reactor.core.publisher.Mono;

public class ExternalServiceClient extends AbstractHttpClient {

    // Prerequisite: start external-services.jar with "java -jar external-services.jar"
    public Mono<String> getProductName(int productId) {
        return this.httpClient.get()
                .uri("/demo01/product/" + productId)
                .responseContent()
                .asString()
                .next();
    }

}
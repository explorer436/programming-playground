package reactive.programming.examples.client;

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
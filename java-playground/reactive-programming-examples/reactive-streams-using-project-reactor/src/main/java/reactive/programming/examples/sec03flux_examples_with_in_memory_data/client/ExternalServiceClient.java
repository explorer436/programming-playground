package reactive.programming.examples.sec03flux_examples_with_in_memory_data.client;

import reactive.programming.examples.utilities.client.AbstractHttpClient;
import reactor.core.publisher.Flux;

/**
 * Prerequisite: start external-services.jar with "java -jar external-services.jar"
 */
public class ExternalServiceClient extends AbstractHttpClient {

    public Flux<String> getNames() {
        return this.httpClient.get()
                .uri("/demo02/name/stream")
                .responseContent()
                .asString();
    }

    /**
     * The stock service will emit price changes every 500ms for ~20 seconds.
     * The price might change between 80-120.
     */
    public Flux<Integer> getPriceChanges() {
        return this.httpClient.get()
                .uri("/demo02/stock/stream")
                .responseContent()
                .asString()
                .map(Integer::parseInt);
    }

}

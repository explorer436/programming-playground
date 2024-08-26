package kafka.examples.analytics.service;

import kafka.examples.analytics.service.dto.ProductTrendingDto;
import kafka.examples.analytics.service.event.ProductViewEvent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.kafka.sender.SenderRecord;
import reactor.kafka.sender.SenderResult;
import reactor.test.StepVerifier;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@AutoConfigureWebTestClient
class AnalyticsServiceApplicationTests extends AbstractIntegrationTest {

    @Autowired
    private WebTestClient client;

	/*@Test
	void contextLoads() {
	}*/

    @Test
    void trendingTest() {

        // emit events from a dummy producer
        Flux<SenderRecord<String, ProductViewEvent, String>> events = Flux.just(
                        createEvent(2, 2),
                        createEvent(1, 1),
                        createEvent(6, 3),
                        createEvent(4, 2),
                        createEvent(5, 5),
                        createEvent(4, 2),
                        createEvent(6, 3),
                        createEvent(3, 3)
                )
                .flatMap(Flux::fromIterable)
                .map(e -> toSenderRecord(PRODUCT_VIEW_EVENTS, e.getProductId().toString(), e));

        // create a sender and send these events
        Flux<SenderResult<String>> resultFlux = this.<ProductViewEvent>createSender().send(events);
        // Someone has to subscribe to this

        StepVerifier.create(resultFlux)
                .expectNextCount(21)
                .verifyComplete();

        // verify via trending endpoint
        Mono<List<ProductTrendingDto>> mono = this.client
                .get()
                .uri("trending")
                .accept(MediaType.TEXT_EVENT_STREAM)
                .exchange()
                .returnResult(new ParameterizedTypeReference<List<ProductTrendingDto>>() {})
                .getResponseBody()
                // The flux will never be complete - because the output is a stream.
                // So, just process the next one.
                .next();

        StepVerifier.create(mono)
                .consumeNextWith(this::validateResult)
                .verifyComplete();
    }

    // 6,5,4,3,2
    private void validateResult(List<ProductTrendingDto> list) {
        assertEquals(5, list.size());

        assertEquals(6, list.get(0).getProductId());
        assertEquals(6, list.get(0).getViewCount());

        assertEquals(2, list.get(4).getProductId());
        assertEquals(2, list.get(4).getViewCount());

        assertTrue(list.stream().noneMatch(p -> p.getProductId() == 1));
    }

    // To simulate events for a given productId
    private List<ProductViewEvent> createEvent(int productId, int count) {
        return IntStream
                .rangeClosed(1, count)
                .mapToObj(i -> new ProductViewEvent(productId))
                .collect(Collectors.toList());
    }

}

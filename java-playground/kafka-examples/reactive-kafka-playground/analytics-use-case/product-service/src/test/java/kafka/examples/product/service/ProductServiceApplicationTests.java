package kafka.examples.product.service;

import kafka.examples.product.service.event.ProductViewEvent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.kafka.receiver.ReceiverRecord;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

@AutoConfigureWebTestClient
class ProductServiceApplicationTests extends AbstractIntegrationTest {

	/*@Test
	void contextLoads() {
	}*/

	@Autowired
	private WebTestClient webTestClient;

	@Test
	void productViewAndEventTest() {

		// view products
		viewProductHappyPath(1);
		viewProductHappyPath(1);

		// This will create an error - since a record with this id does not exist in the database.
		viewProductError(1000);

		viewProductHappyPath(5);

		// check if the events are emitted
		// How do we do it?
		// We have to create a receiver and use the receiver to read messages from the topic and validate.

		Flux<ReceiverRecord<String, ProductViewEvent>> flux = this.<ProductViewEvent>createReceiver(PRODUCT_VIEW_EVENTS)
				.receive()
				.take(3);

		StepVerifier.create(flux)
				.consumeNextWith(r -> assertAll(
						"Grouped Assertions of ProductViewEvent",
						() -> assertNotNull(r.value().getProductId()),
						() -> assertEquals(1, r.value().getProductId()))
				)
				.consumeNextWith(r -> assertAll(
						"Grouped Assertions of ProductViewEvent",
						() -> assertNotNull(r.value().getProductId()),
						() -> assertEquals(1, r.value().getProductId()))
				)
				.consumeNextWith(r -> assertAll(
						"Grouped Assertions of ProductViewEvent",
						() -> assertNotNull(r.value().getProductId()),
						() -> assertEquals(5, r.value().getProductId()))
				)
				.verifyComplete();
	}

	private void viewProductHappyPath(int id) {
		webTestClient
				.get()
				.uri("/product/" + id)
				.exchange()
				.expectStatus().is2xxSuccessful()
				.expectBody()
				.jsonPath("$.id").isEqualTo(id)
				.jsonPath("$.description").isEqualTo("product-" + id);
	}

	private void viewProductError(int id) {
		webTestClient
				.get()
				.uri("/product/" + id)
				.exchange()
				.expectStatus().is4xxClientError();
	}

}

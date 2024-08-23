package kafka.examples.analytics.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

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



		// verify via trending endpoint

	}

}

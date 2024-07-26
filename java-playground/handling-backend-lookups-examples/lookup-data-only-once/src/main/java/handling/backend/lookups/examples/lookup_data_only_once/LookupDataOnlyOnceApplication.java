package handling.backend.lookups.examples.lookup_data_only_once;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class LookupDataOnlyOnceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LookupDataOnlyOnceApplication.class, args);
	}

}

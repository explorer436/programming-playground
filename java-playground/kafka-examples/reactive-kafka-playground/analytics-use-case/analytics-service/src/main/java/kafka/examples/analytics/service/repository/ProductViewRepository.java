package kafka.examples.analytics.service.repository;

import kafka.examples.analytics.service.entity.ProductViewCount;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ProductViewRepository extends ReactiveCrudRepository<ProductViewCount, Integer> {

    Flux<ProductViewCount> findTop5ByOrderByCountDesc();

}

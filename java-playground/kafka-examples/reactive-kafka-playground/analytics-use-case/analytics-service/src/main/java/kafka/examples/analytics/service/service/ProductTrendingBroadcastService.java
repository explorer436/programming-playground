package kafka.examples.analytics.service.service;

import jakarta.annotation.PostConstruct;
import kafka.examples.analytics.service.dto.ProductTrendingDto;
import kafka.examples.analytics.service.entity.ProductViewCount;
import kafka.examples.analytics.service.repository.ProductViewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.function.Predicate;

@Service
@RequiredArgsConstructor
public class ProductTrendingBroadcastService {

    private final ProductViewRepository productViewRepository;
    private Flux<List<ProductTrendingDto>> trends;

    @PostConstruct
    private void init() {
        Flux<ProductViewCount> productViewCountFlux = productViewRepository.findTop5ByOrderByCountDesc();

        trends = productViewCountFlux
                // Flux to Mono
                .map(productViewCount -> new ProductTrendingDto(productViewCount.getId(), productViewCount.getCount()))
                .collectList()
                .filter(Predicate.not(List::isEmpty))
                .repeatWhen(
                        l -> l.delayElements(Duration.ofSeconds(3))
                )
                .distinctUntilChanged()
                .cache(1);
    }

    public Flux<List<ProductTrendingDto>> getTrends() {
        return trends;
    }
}

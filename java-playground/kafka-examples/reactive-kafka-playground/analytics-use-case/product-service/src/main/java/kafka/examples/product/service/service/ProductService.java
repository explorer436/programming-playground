package kafka.examples.product.service.service;

import kafka.examples.product.service.dto.ProductDto;
import kafka.examples.product.service.event.ProductViewEvent;
import kafka.examples.product.service.repository.ProductRepository;
import kafka.examples.product.service.util.EntityDtoUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductViewEventProducer productViewEventProducer;

    public Mono<ProductDto> getProduct(int id) {
        return productRepository.findById(id)
                .doOnNext(event -> productViewEventProducer.emitEvent(new ProductViewEvent(event.getId())))
                .map(EntityDtoUtil::toDto);
    }
}

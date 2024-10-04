package com.my.company.inventory.application.service;

import com.my.company.common.messages.inventory.InventoryStatus;
import com.my.company.common.util.DuplicateEventValidator;
import com.my.company.inventory.application.entity.OrderInventory;
import com.my.company.inventory.application.entity.Product;
import com.my.company.inventory.application.mapper.EntityDtoMapper;
import com.my.company.inventory.application.repository.InventoryRepository;
import com.my.company.inventory.application.repository.ProductRepository;
import com.my.company.inventory.common.dto.InventoryDeductRequest;
import com.my.company.inventory.common.dto.OrderInventoryDto;
import com.my.company.inventory.common.exception.OutOfStockException;
import com.my.company.inventory.common.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private static final Logger log = LoggerFactory.getLogger(InventoryServiceImpl.class);
    private static final Mono<Product> OUT_OF_STOCK = Mono.error(new OutOfStockException());
    private final ProductRepository productRepository;
    private final InventoryRepository inventoryRepository;

    @Override
    @Transactional
    public Mono<OrderInventoryDto> deduct(InventoryDeductRequest request) {
        return DuplicateEventValidator.validate(
                                              this.inventoryRepository.existsByOrderId(request.orderId()),
                                              this.productRepository.findById(request.productId())
                                      )
                                      .filter(p -> p.getAvailableQuantity() >= request.quantity())
                                      .switchIfEmpty(OUT_OF_STOCK)
                                      .flatMap(p -> this.deductInventory(p, request))
                                      .doOnNext(dto -> log.info("inventory deducted for {}", dto.orderId()));
    }

    private Mono<OrderInventoryDto> deductInventory(Product product, InventoryDeductRequest request) {
        var orderInventory = EntityDtoMapper.toOrderInventory(request);
        product.setAvailableQuantity(product.getAvailableQuantity() - request.quantity());
        orderInventory.setStatus(InventoryStatus.DEDUCTED);
        return this.productRepository.save(product)
                                      .then(this.inventoryRepository.save(orderInventory))
                                      .map(EntityDtoMapper::toDto);
    }

    @Override
    @Transactional
    public Mono<OrderInventoryDto> restore(UUID orderId) {
        return this.inventoryRepository.findByOrderIdAndStatus(orderId, InventoryStatus.DEDUCTED)
                                     .zipWhen(i -> this.productRepository.findById(i.getProductId()))
                                     .flatMap(t -> this.restore(t.getT1(), t.getT2()))
                                     .doOnNext(dto -> log.info("restored quantity {} for {}", dto.quantity(), dto.orderId()));
    }

    private Mono<OrderInventoryDto> restore(OrderInventory orderInventory, Product product) {
        product.setAvailableQuantity(product.getAvailableQuantity() + orderInventory.getQuantity());
        orderInventory.setStatus(InventoryStatus.RESTORED);
        return this.productRepository.save(product)
                                      .then(this.inventoryRepository.save(orderInventory))
                                      .map(EntityDtoMapper::toDto);
    }

}

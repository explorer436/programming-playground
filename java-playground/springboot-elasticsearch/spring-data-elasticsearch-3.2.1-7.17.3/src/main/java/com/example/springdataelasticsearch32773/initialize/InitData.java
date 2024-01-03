package com.example.springdataelasticsearch32773.initialize;

import com.example.springdataelasticsearch32773.model.Product;
import com.example.springdataelasticsearch32773.repositories.ProductRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.*;

@Component
@RequiredArgsConstructor
@Slf4j
public class InitData {

    private static final String COMMA_DELIMITER = ",";

    private final ProductRepository productRepository;

    @PostConstruct
    public void load() throws JsonProcessingException {

        productRepository.deleteAll();
        productRepository.saveAll(prepareDataset());
    }

    private Collection<Product> prepareDataset() {
        Resource resource = new ClassPathResource("fashion-products.csv");
        List<Product> productList = new ArrayList<Product>();

        try (
                InputStream input = resource.getInputStream();
                Scanner scanner = new Scanner(resource.getInputStream());) {
            int lineNo = 0;
            while (scanner.hasNextLine()) {
                ++lineNo;
                String line = scanner.nextLine();
                if (lineNo == 1) continue;
                Optional<Product> product =
                        csvRowToProductMapper(line);
                if (product.isPresent())
                    productList.add(product.get());
            }
        } catch (Exception e) {
            log.error("File read error {}", e);
            ;
        }
        return productList;
    }

    private Optional<Product> csvRowToProductMapper(final String line) {
        try (
                Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(COMMA_DELIMITER);
            while (rowScanner.hasNext()) {
                String name = rowScanner.next();
                String description = rowScanner.next();
                String manufacturer = rowScanner.next();
                return Optional.of(
                        Product.builder()
                                .name(name)
                                .description(description)
                                .manufacturer(manufacturer)
                                .build());

            }
        }
        return Optional.of(null);
    }


}

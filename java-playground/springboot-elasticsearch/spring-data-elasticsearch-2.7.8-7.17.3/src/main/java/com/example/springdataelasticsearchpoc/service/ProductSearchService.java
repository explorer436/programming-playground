package com.example.springdataelasticsearchpoc.service;

import com.example.springdataelasticsearchpoc.model.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.IndexedObjectInformation;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.StringQuery;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductSearchService {

    private static final String PRODUCT_INDEX = "productindex";

    private final ElasticsearchOperations elasticsearchOperations;

    public List<String> createProductIndexBulk(final List<Product> products) {

        List<IndexQuery> queries = products.stream()
                .map(product -> new IndexQueryBuilder().withId(product.getId().toString()).withObject(product).build())
                .collect(Collectors.toList());
        ;
        List<IndexedObjectInformation> indexedObjectInformationList = elasticsearchOperations.bulkIndex(queries, IndexCoordinates.of(PRODUCT_INDEX));

        List<String> result = new ArrayList<>();
        indexedObjectInformationList.forEach(i -> {
            result.add(i.getId());
        });

        return result;
    }

    public String createProductIndex(Product product) {

        IndexQuery indexQuery = new IndexQueryBuilder().withId(product.getId().toString()).withObject(product).build();

        String documentId = elasticsearchOperations.index(indexQuery, IndexCoordinates.of(PRODUCT_INDEX));

        return documentId;
    }

    public void findProductsByBrand(final String brandName) {

        QueryBuilder queryBuilder = QueryBuilders
                .matchQuery("manufacturer", brandName);

        // .fuzziness(0.8)
        // .boost(1.0f)
        // .prefixLength(0)
        // .fuzzyTranspositions(true);

        Query searchQuery = new NativeSearchQueryBuilder()
                .withQuery(queryBuilder)
                .build();

        SearchHits<Product> productHits =
                elasticsearchOperations
                        .search(searchQuery, Product.class,
                                IndexCoordinates.of(PRODUCT_INDEX));

        log.info("productHits {} {}", productHits.getSearchHits().size(), productHits.getSearchHits());

        List<SearchHit<Product>> searchHits =
                productHits.getSearchHits();
        int i = 0;
        for (SearchHit<Product> searchHit : searchHits) {
            log.info("searchHit {}", searchHit);
        }

    }

    public void findByProductName(final String productName) {
        Query searchQuery = new StringQuery(
                "{\"match\":{\"name\":{\"query\":\""+ productName + "\"}}}\"");

        SearchHits<Product> products = elasticsearchOperations.search(searchQuery, Product.class,
                IndexCoordinates.of(PRODUCT_INDEX));
    }

    public void findByProductPrice(final String productPrice) {
        Criteria criteria = new Criteria("price").greaterThan(10.0).lessThan(100.0);
        Query searchQuery = new CriteriaQuery(criteria);

        SearchHits<Product> products = elasticsearchOperations.search(searchQuery, Product.class,
                IndexCoordinates.of(PRODUCT_INDEX));
    }

    public List<Product> processSearch(final String query) {
        log.info("Search with query {}", query);

        // 1. Create query on multiple fields enabling fuzzy search
        QueryBuilder queryBuilder =
                QueryBuilders
                        .multiMatchQuery(query, "name", "description")
                        .fuzziness(Fuzziness.AUTO);

        Query searchQuery = new NativeSearchQueryBuilder()
                .withFilter(queryBuilder)
                .build();

        // 2. Execute search
        SearchHits<Product> productHits =
                elasticsearchOperations
                        .search(searchQuery, Product.class,
                                IndexCoordinates.of(PRODUCT_INDEX));

        // 3. Map searchHits to product list
        List<Product> productMatches = new ArrayList<Product>();
        productHits.forEach(srchHit->{
            productMatches.add(srchHit.getContent());
        });
        return productMatches;
    }




    public List<String> fetchSuggestions(String query) {

        QueryBuilder queryBuilder = QueryBuilders
                .wildcardQuery("name", query+"*");

        Query searchQuery = new NativeSearchQueryBuilder()
                .withFilter(queryBuilder)
                .withPageable(PageRequest.of(0, 5))
                .build();

        SearchHits<Product> searchSuggestions =
                elasticsearchOperations.search(searchQuery,
                        Product.class,
                        IndexCoordinates.of(PRODUCT_INDEX));

        List<String> suggestions = new ArrayList<String>();

        searchSuggestions.getSearchHits().forEach(searchHit->{
            suggestions.add(searchHit.getContent().getName());
        });
        return suggestions;
    }

}

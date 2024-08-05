package enterprise.search.examples.opensearch_java_demo.connector;

import enterprise.search.examples.opensearch_java_demo.client.OpensearchClientCreator;
import enterprise.search.examples.opensearch_java_demo.model.MyDocument;
import jakarta.annotation.PostConstruct;
import jakarta.json.stream.JsonParser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.opensearch.OpenSearchClient;
import org.opensearch.client.opensearch._types.SortOptions;
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.opensearch._types.mapping.TypeMapping;
import org.opensearch.client.opensearch._types.query_dsl.Query;
import org.opensearch.client.opensearch.cluster.PutComponentTemplateRequest;
import org.opensearch.client.opensearch.core.*;
import org.opensearch.client.opensearch.indices.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Component
public class ClientConnector {

    @Value("${cloudsearch.index1}")
    private String indexName1;

    @Value("${cloudsearch.index2}")
    private String indexName2;

    private final OpensearchClientCreator opensearchClientCreator;

    private final MustacheImpl mustacheImpl;

    @PostConstruct
    public void setupIndexes() throws NoSuchAlgorithmException, KeyStoreException, IOException, KeyManagementException {
        setupIndex(indexName1, "mapping1.json");
        setupIndex(indexName2, "mapping2.json");
    }

    private void setupIndex(String indexName, String mappingFilename) throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException, IOException {
        if (!hasIndex(indexName)) {
            createIndex(indexName, mappingFilename);
        }
    }

    public boolean hasIndex(String indexName) throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException, IOException {
        log.info(">>> hasIndex()");

        OpenSearchClient openSearchClient = getOpenSearchClient();

        // OpenSearchVersionInfo version = openSearchClient.info().version();
        // log.info("Server: {}@{}", version.distribution(), version.number());

        if (openSearchClient.indices().exists(r -> r.index(indexName)).value()) {
            return true;
        }

        return false;
    }

    private void createIndex(String indexName, String mappingFilename) throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        log.info(">>> createIndex()");

        OpenSearchClient openSearchClient = getOpenSearchClient();

        // OpenSearchVersionInfo version = openSearchClient.info().version();
        // log.info("Server: {}@{}", version.distribution(), version.number());



        /*if (openSearchClient.indices().existsIndexTemplate(t -> t.name(indexTemplateName)).value()) {
            DeleteIndexTemplateRequest deleteIndexTemplateRequest = DeleteIndexTemplateRequest.of(i -> i.name(indexTemplateName));
            log.info("Deleting index template {}", indexTemplateName);
            openSearchClient.indices().deleteIndexTemplate(deleteIndexTemplateRequest);
        }*/

        // Create an index template composed of two component templates, one for index settings, and one for mappings
        String indexSettingsComponentTemplate = indexName + "-settings";

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(mappingFilename);
        JsonpMapper mapper = openSearchClient._transport().jsonpMapper();
        JsonParser parser = mapper.jsonProvider().createParser(inputStream);
        // CreateIndexRequest.Builder().index(index).mappings(TypeMapping._DESERIALIZER.deserialize(parser, mapper))

        PutComponentTemplateRequest putComponentTemplateRequest = PutComponentTemplateRequest.of(
                c -> c.name(indexSettingsComponentTemplate)
                        .template(
                                templt -> templt
                                        .mappings(TypeMapping._DESERIALIZER.deserialize(parser, mapper))
                                        .settings(
                                                s -> s.numberOfShards("5")
                                                        .numberOfReplicas("1")
                                                        .indexing(
                                                                i -> i.slowlog(
                                                                        sl -> sl.level("info")
                                                                                .reformat(true)
                                                                                .threshold(th -> th.index(ith -> ith.warn(Time.of(t -> t.time("2s")))))
                                                                )
                                                        )
                                                        .search(
                                                                se -> se.slowlog(sl -> sl.level("info").threshold(th -> th.query(q -> q.warn(Time.of(t -> t.time("2s"))))))
                                                        )
                                        )
                        )

        );
        log.info("Creating component template {}", indexSettingsComponentTemplate);
        openSearchClient.cluster().putComponentTemplate(putComponentTemplateRequest);

        /*String indexMappingsComponentTemplate = indexName + "-mappings";
        putComponentTemplateRequest = PutComponentTemplateRequest.of(
                c -> c.name(indexMappingsComponentTemplate)
                        .mappings(m -> m.properties("age", p -> p.integer(i -> i)))
        );
        log.info("Creating component template {}", indexMappingsComponentTemplate);
        openSearchClient.cluster().putComponentTemplate(putComponentTemplateRequest);*/

        String indexTemplateName = indexName + "-template";
        PutIndexTemplateRequest putIndexTemplateRequest = PutIndexTemplateRequest.of(
                it -> it.name(indexTemplateName)
                        .indexPatterns(indexName)
                        // .composedOf(List.of(indexSettingsComponentTemplate, indexMappingsComponentTemplate))
                        .composedOf(List.of(indexSettingsComponentTemplate))
        );

        log.info("Creating index template {}", indexTemplateName);
        openSearchClient.indices().putIndexTemplate(putIndexTemplateRequest);

        /*if (openSearchClient.indices().exists(r -> r.index(indexName)).value()) {
            log.info("Deleting index {}", indexName);
            openSearchClient.indices().delete(DeleteIndexRequest.of(d -> d.index(indexName)));
        }*/

        log.info("Creating index {}", indexName);
        openSearchClient.indices().create(CreateIndexRequest.of(c -> c.index(indexName)));

    }

    public GetMappingResponse getMappingResponse(String indexName) throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException, IOException {

        OpenSearchClient openSearchClient = getOpenSearchClient();

        GetMappingResponse getMappingResponse = openSearchClient.indices().getMapping(GetMappingRequest.of(m -> m.index(indexName)));
        // mappings for the index should contain those defined in component template
        log.info("Mappings {} found for index {}", getMappingResponse.result().get(indexName).mappings(), indexName);

        return getMappingResponse;

    }

    public GetIndicesSettingsResponse getGetIndicesSettingsResponse(String indexName) throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException, IOException {

        OpenSearchClient openSearchClient = getOpenSearchClient();

        GetIndicesSettingsResponse getSettingsResponse = openSearchClient.indices()
                .getSettings(GetIndicesSettingsRequest.of(m -> m.index(indexName)));
        // settings for the index should contain those defined in component template
        log.info("Settings {} found for index {}", getSettingsResponse.result().get(indexName).settings(), indexName);

        return getSettingsResponse;
    }

    public String insertDocument(MyDocument myDocument) throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        IndexRequest<MyDocument> indexRequest = new IndexRequest.Builder<MyDocument>().index(indexName2)
                .document(myDocument)
                .build();

        OpenSearchClient openSearchClient = getOpenSearchClient();
        IndexResponse indexResponse = openSearchClient.index(indexRequest);
        return indexResponse.id();
    }

    public boolean bulkInsertDocuments(List<MyDocument> myDocuments) throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException, IOException {
        OpenSearchClient openSearchClient = getOpenSearchClient();

        BulkRequest.Builder bulkRequestBuilder = new BulkRequest.Builder();
        for (MyDocument myDocument : myDocuments) {
            bulkRequestBuilder.operations(b -> b.index(o -> o.index(indexName2).document(myDocument)));
        }
        BulkResponse bulkResponse = openSearchClient.bulk(bulkRequestBuilder.build());

        log.info("bulkResponse.errors(): {}", bulkResponse.errors());
        log.info("bulkResponse.took(): {}", bulkResponse.took());
        log.info("bulkResponse.ingestTook(): {}", bulkResponse.ingestTook());

        log.info("bulkResponse.toJsonString(): {}", bulkResponse.toJsonString());

        return !bulkResponse.errors();
    }

    public List<MyDocument> fetchDocumentByUsername(String username) throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException, IOException {
        OpenSearchClient openSearchClient = getOpenSearchClient();

        /*
        {
            "from":0,
            "size":10000,
            "_source": ["docName","userName","createdOn","status"],
            "sort": [
              {
                "createdOn": {
                  "order": "desc"
                }
              }
            ],
            "query": {
                "term": {
                  "userName.keyword": {
                    "value": "{{username}}"
                  }
                }
            }
        }
         */

        String sortString = """
                {
                  "createdOn": {
                    "order": "desc"
                  }
                }""";
        InputStream inputStream = new ByteArrayInputStream(sortString.getBytes(StandardCharsets.UTF_8));
        JsonpMapper mapper = openSearchClient._transport().jsonpMapper();
        JsonParser parser = mapper.jsonProvider().createParser(inputStream);

        SearchRequest searchRequest1 = new SearchRequest.Builder()
                .index(indexName2)
                .from(0)
                .size(10000)
                .source(sorc -> sorc.filter(f -> f.includes("docName", "userName", "createdOn", "status")))
                .sort(SortOptions._DESERIALIZER.deserialize(parser, mapper))
                .query(q -> q.queryString(qs -> qs.fields("userName").query(username)))
                .build();

        SearchResponse<MyDocument> searchResponse = openSearchClient.search(searchRequest1, MyDocument.class);

        // log.info("searchResponse.toJsonString(): {}", searchResponse.toJsonString());

        for (var hit : searchResponse.hits().hits()) {
            log.info("Found {} with score {}", hit.source(), hit.score());
        }

        return searchResponse.hits().hits().stream().map(
                h -> h.source()
        ).collect(Collectors.toUnmodifiableList());
    }

    public List<MyDocument> fetchDocumentByDocumentId(String documentId) throws Exception {
        OpenSearchClient openSearchClient = getOpenSearchClient();

        Map params = new HashMap<>();
        params.put("documentId", documentId);
        String query = mustacheImpl.template(params, "searchForMyDocumentById.json");
        log.info("query: {}", query);

        InputStream inputStream = new ByteArrayInputStream(query.getBytes(StandardCharsets.UTF_8));
        JsonpMapper mapper = openSearchClient._transport().jsonpMapper();
        JsonParser parser = mapper.jsonProvider().createParser(inputStream);

        SearchRequest searchRequest = SearchRequest._DESERIALIZER.deserialize(parser, mapper);

        SearchResponse<MyDocument> searchResponse = openSearchClient.search(searchRequest, MyDocument.class);

        for (var hit : searchResponse.hits().hits()) {
            log.info("Found {} with score {}", hit.source(), hit.score());
        }

        return searchResponse.hits().hits().stream().map(
                h -> h.source()
        ).collect(Collectors.toUnmodifiableList());
    }

    /**
     * Do not use the approach of setting individual parameters.
     * Instead, put the entire template for the query in a json file and fill the parameters as necessary.
     * See "fetchDocumentByDocumentId()"
     */
    public List<MyDocument> fetchDocumentByDocumentId2(String documentId) throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException, IOException {
        OpenSearchClient openSearchClient = getOpenSearchClient();

        String sortString = """
                "match": { "_id": "ALe9BpEBLWvOEL9OHOmL"
                }""";
        InputStream inputStream = new ByteArrayInputStream(sortString.getBytes(StandardCharsets.UTF_8));
        JsonpMapper mapper = openSearchClient._transport().jsonpMapper();
        JsonParser parser = mapper.jsonProvider().createParser(inputStream);

        SearchRequest searchRequest1 = new SearchRequest.Builder()
                .index(indexName2)
                .from(0)
                .size(10000)
                // .query(q -> q.queryString(qs -> qs.fields("_id").query(documentId)))
                .query(Query._DESERIALIZER.deserialize(parser, mapper))
                .build();

        SearchResponse<MyDocument> searchResponse = openSearchClient.search(searchRequest1, MyDocument.class);

        for (var hit : searchResponse.hits().hits()) {
            log.info("Found {} with score {}", hit.source(), hit.score());
        }

        return searchResponse.hits().hits().stream().map(
                h -> h.source()
        ).collect(Collectors.toUnmodifiableList());
    }

    public List<MyDocument> fetchDocumentsWithMustQuery(MyDocument myDocument) {
        return List.of();
    }

    public List<MyDocument> fetchDocumentsWithShouldQuery(MyDocument myDocument) {
        return List.of();
    }

    public String deleteDocumentById(Long id) {
        return "";
    }

    public String updateDocument(MyDocument myDocument) {
        return "";
    }

    private OpenSearchClient getOpenSearchClient() throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        OpenSearchClient openSearchClient = opensearchClientCreator.create();
        return openSearchClient;
    }
}

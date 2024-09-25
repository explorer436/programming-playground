package enterprise.search.examples.opensearch_java_demo.connector;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import enterprise.search.examples.opensearch_java_demo.client.OpensearchClientCreator;
import enterprise.search.examples.opensearch_java_demo.model.Movie;
import enterprise.search.examples.opensearch_java_demo.model.MyDocument;
import jakarta.annotation.PostConstruct;
import jakarta.json.stream.JsonParser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.opensearch.OpenSearchClient;
import org.opensearch.client.opensearch._types.Result;
import org.opensearch.client.opensearch._types.Script;
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

    @Value("${cloudsearch.movies.index}")
    private String moviesIndex;

    private final OpensearchClientCreator opensearchClientCreator;

    private final MustacheImpl mustacheImpl;

    @PostConstruct
    public void setupIndexes() throws NoSuchAlgorithmException, KeyStoreException, IOException, KeyManagementException {
        setupIndex(indexName1, "mapping1.json");
        setupIndex(indexName2, "mapping2.json");
        setupIndex(moviesIndex, "moviesIndexMapping.json");
    }

    private void setupIndex(String indexName, String mappingFilename) throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException, IOException {
        boolean indexExists = hasIndex(indexName);
        log.info("index {} exists: {}", indexName, indexExists);
        if (!indexExists) {
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
                // .id() for updates.
                .document(myDocument)
                .build();

        log.info("indexRequest: {}", javaToJson(indexRequest));

        OpenSearchClient openSearchClient = getOpenSearchClient();
        IndexResponse indexResponse = openSearchClient.index(indexRequest);
        return indexResponse.id();
    }

    public String insertMovie(Movie movie) throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        IndexRequest<Movie> indexRequest = new IndexRequest.Builder<Movie>().index(indexName2)
                .document(movie)
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
        String query = mustacheImpl.template(params, "query-MyDocumentById.json");
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

    public String deleteDocumentById(String documentId) throws Exception {
        OpenSearchClient openSearchClient = getOpenSearchClient();

        DeleteResponse deleteResponse = openSearchClient.delete(d -> d.index(indexName2).id(documentId));

        log.info("deleteResponse: {}", deleteResponse.toJsonString());

        if (deleteResponse.result().compareTo(Result.Deleted) == 0) {
            return "success";
        } else {
            return "failure";
        }
    }

    public List<Movie> fetchMovieByName(String name) throws Exception {
        OpenSearchClient openSearchClient = getOpenSearchClient();

        Map params = new HashMap<>();
        params.put("name", name);
        String query = mustacheImpl.template(params, "query-MovieByName.json");
        log.info("query: {}", query);

        InputStream inputStream = new ByteArrayInputStream(query.getBytes(StandardCharsets.UTF_8));
        JsonpMapper mapper = openSearchClient._transport().jsonpMapper();
        JsonParser parser = mapper.jsonProvider().createParser(inputStream);

        SearchRequest searchRequest = SearchRequest._DESERIALIZER.deserialize(parser, mapper);

        SearchResponse<Movie> searchResponse = openSearchClient.search(searchRequest, Movie.class);

        for (var hit : searchResponse.hits().hits()) {
            log.info("Found {} with score {}", hit.source(), hit.score());
        }

        return searchResponse.hits().hits().stream().map(
                h -> h.source()
        ).collect(Collectors.toUnmodifiableList());
    }

    public void updateDocument(MyDocument myDocument) throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException, IOException {

        // Update the entire object.
        /*UpdateRequest<Employee, Employee> updateRequest = UpdateRequest.of(builder->
                builder.index(index)
                        .id(String.valueOf(employee.getId()))
                        .doc(employee));
        UpdateResponse<Employee> response = elasticsearchClient.update(updateRequest, Employee.class);*/

        /*
           POST employee-index1/_update_by_query
           {
               "script": {
                   "source": "ctx._source.deleteFlag='Y';",
                   "lang": "painless"
               },
               "query": {
                   "term": {
                       "employeeId": {
                           "value": 1234
                       }
                   }
               }
           }
        */

        /*
            POST test-index1/_update_by_query
            {
              "query": {
                "term": {
                  "oldValue": 10
                }
              },
              "script" : {
                "source": "ctx._source.oldValue += params.newValue",
                "lang": "painless",
                "params" : {
                  "newValue" : 20
                }
              }
            }
         */

        // Based on the use-case, this maybe more appropriate compared to UpdateRequest.
        UpdateByQueryRequest updateByQueryRequest = UpdateByQueryRequest.of(builder ->
                builder.index(indexName1)
                        .script(Script.of(s ->
                                s.inline(i -> {
                                            i.lang("painless");
                                            i.source("ctx._source.deleteFlag='Y';");
                                            return i;
                                        }

                                )))
                        .query(q -> {
                                    q.term(t -> {
                                        t.field("employeeId");
                                        t.value(v -> {
                                            v.longValue(1234L);
                                            return v;
                                        });
                                        return t;
                                    });
                                    return q;
                                }
                        ));
        UpdateByQueryResponse updateByQueryResponse = getOpenSearchClient().updateByQuery(updateByQueryRequest);

        if (updateByQueryResponse.updated() == 0) {
            log.error("document update failed: {}", updateByQueryResponse.toJsonString());
        } else {
            log.info("updated count {} for query {} and response is {}",
                    updateByQueryResponse.updated(),
                    updateByQueryRequest.query().toString(),
                    updateByQueryResponse.toJsonString());
        }
    }

    private OpenSearchClient getOpenSearchClient() throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        OpenSearchClient openSearchClient = opensearchClientCreator.create();
        return openSearchClient;
    }

    private String javaToJson(IndexRequest input) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

        // com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Java 8 date/time type `java.time.LocalDate` not supported by default: add Module "com.fasterxml.jackson.datatype:jackson-datatype-jsr310" to enable handling (through reference chain: com.example.jacksonjsonpoc.objectmapper.model.Employee["joinedDate"])

        objectMapper.registerModule(new JavaTimeModule());

        // No serializer found for class org.opensearch.client.opensearch.core.IndexRequest and no properties discovered to create BeanSerializer (to avoid exception, disable SerializationFeature.FAIL_ON_EMPTY_BEANS)
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(input);
    }
}

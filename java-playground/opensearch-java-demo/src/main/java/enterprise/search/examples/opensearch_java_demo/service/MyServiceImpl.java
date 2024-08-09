package enterprise.search.examples.opensearch_java_demo.service;

import enterprise.search.examples.opensearch_java_demo.connector.ClientConnector;
import enterprise.search.examples.opensearch_java_demo.model.Movie;
import enterprise.search.examples.opensearch_java_demo.model.MyDocument;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.opensearch.client.opensearch.indices.GetIndicesSettingsResponse;
import org.opensearch.client.opensearch.indices.GetMappingResponse;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MyServiceImpl implements MyService {

    private final ClientConnector clientConnector;

    @Override
    public boolean hasIndex(String indexName) throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException, IOException {
        log.info(">>> hasIndex()");
        return clientConnector.hasIndex(indexName);
    }

    @Override
    public GetMappingResponse getMappingResponse(String indexName) throws NoSuchAlgorithmException, KeyStoreException, IOException, KeyManagementException {
        return clientConnector.getMappingResponse(indexName);
    }

    @Override
    public GetIndicesSettingsResponse getIndicesSettingsResponse(String indexName) throws NoSuchAlgorithmException, KeyStoreException, IOException, KeyManagementException {
        return clientConnector.getGetIndicesSettingsResponse(indexName);
    }

    @Override
    public List<MyDocument> fetchDocumentByUsername(String username) throws NoSuchAlgorithmException, KeyStoreException, IOException, KeyManagementException {
        return clientConnector.fetchDocumentByUsername(username);
    }

    @Override
    public String insertDocument(MyDocument myDocument) throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {

        myDocument.setCreatedOn(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a").format(new Date()));

        return clientConnector.insertDocument(myDocument);
    }

    @Override
    public String insertMovie(Movie movie) throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        return clientConnector.insertMovie(movie);
    }

    @Override
    public boolean bulkInsertDocuments(List<MyDocument> myDocuments) throws NoSuchAlgorithmException, KeyStoreException, IOException, KeyManagementException {
        return clientConnector.bulkInsertDocuments(myDocuments);
    }

    @Override
    public String deleteDocumentById(String documentId) throws Exception {
        return clientConnector.deleteDocumentById(documentId);
    }

    @Override
    public String updateDocument(MyDocument myDocument) throws IOException {
        return clientConnector.updateDocument(myDocument);
    }

    @Override
    public List<MyDocument> fetchDocumentByDocumentId(String documentId) throws Exception {
        return clientConnector.fetchDocumentByDocumentId(documentId);
    }

    @Override
    public List<Movie> fetchMovieByName(String name) throws Exception {
        return clientConnector.fetchMovieByName(name);
    }
}

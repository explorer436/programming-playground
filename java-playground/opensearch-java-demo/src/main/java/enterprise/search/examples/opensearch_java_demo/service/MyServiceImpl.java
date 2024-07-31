package enterprise.search.examples.opensearch_java_demo.service;

import enterprise.search.examples.opensearch_java_demo.connector.ClientConnector;
import enterprise.search.examples.opensearch_java_demo.exception.RecordNotFoundException;
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
        return clientConnector.insertDocument(myDocument);
    }

    @Override
    public boolean bulkInsertDocuments(List<MyDocument> myDocuments) throws NoSuchAlgorithmException, KeyStoreException, IOException, KeyManagementException {
        return clientConnector.bulkInsertDocuments(myDocuments);
    }

    @Override
    public List<MyDocument> fetchDocumentsWithMustQuery(MyDocument myDocument) throws IOException {
        return clientConnector.fetchDocumentsWithMustQuery(myDocument);
    }

    @Override
    public List<MyDocument> fetchDocumentsWithShouldQuery(MyDocument myDocument) throws IOException {
        return clientConnector.fetchDocumentsWithShouldQuery(myDocument);
    }

    @Override
    public String deleteDocumentById(Long id) throws IOException {
        return clientConnector.deleteDocumentById(id);
    }

    @Override
    public String updateDocument(MyDocument myDocument) throws IOException {
        return clientConnector.updateDocument(myDocument);
    }
}

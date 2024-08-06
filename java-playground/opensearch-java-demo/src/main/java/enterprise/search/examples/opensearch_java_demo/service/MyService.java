package enterprise.search.examples.opensearch_java_demo.service;

import enterprise.search.examples.opensearch_java_demo.exception.RecordNotFoundException;
import enterprise.search.examples.opensearch_java_demo.model.MyDocument;
import org.opensearch.client.opensearch.indices.GetIndicesSettingsResponse;
import org.opensearch.client.opensearch.indices.GetMappingResponse;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface MyService {

    boolean hasIndex(String indexName) throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException, IOException;

    GetMappingResponse getMappingResponse(String indexName) throws NoSuchAlgorithmException, KeyStoreException, IOException, KeyManagementException;

    GetIndicesSettingsResponse getIndicesSettingsResponse(String indexName) throws NoSuchAlgorithmException, KeyStoreException, IOException, KeyManagementException;

    public List<MyDocument> fetchDocumentByUsername(String username) throws NoSuchAlgorithmException, KeyStoreException, IOException, KeyManagementException;

    public String insertDocument(MyDocument myDocument) throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException;

    public boolean bulkInsertDocuments(List<MyDocument> myDocuments) throws NoSuchAlgorithmException, KeyStoreException, IOException, KeyManagementException;

    public String deleteDocumentById(String documentId) throws Exception;

    public String updateDocument(MyDocument myDocument) throws IOException;

    List<MyDocument> fetchDocumentByDocumentId(String documentId) throws Exception;
}

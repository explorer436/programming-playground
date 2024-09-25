package enterprise.search.examples.opensearch_java_demo.controller;

import enterprise.search.examples.opensearch_java_demo.exception.RecordNotFoundException;
import enterprise.search.examples.opensearch_java_demo.model.Movie;
import enterprise.search.examples.opensearch_java_demo.model.MyDocument;
import enterprise.search.examples.opensearch_java_demo.service.MyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.opensearch.client.opensearch.indices.GetIndicesSettingsResponse;
import org.opensearch.client.opensearch.indices.GetMappingResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@RequestMapping("/opensearch/v1")
@RequiredArgsConstructor
@Slf4j
public class MyController {

    private final MyService myService;

    @GetMapping("/index/exists/{index}")
    public ResponseEntity<Boolean> indexExists(@PathVariable("index") String index) throws NoSuchAlgorithmException, KeyStoreException, IOException, KeyManagementException {
        log.info(">>> indexExists()");
        boolean indexExists = myService.hasIndex(index);
        return ResponseEntity.ok(indexExists);
    }

    @GetMapping("/index/mapping/{index}")
    public ResponseEntity<GetMappingResponse> getMappingResponse(@PathVariable("index") String index) throws NoSuchAlgorithmException, KeyStoreException, IOException, KeyManagementException {
        log.info(">>> indexExists()");
        GetMappingResponse mappingResponse = myService.getMappingResponse(index);
        return ResponseEntity.ok(mappingResponse);
    }

    @GetMapping("/index/{index}")
    public ResponseEntity<GetIndicesSettingsResponse> getIndicesSettingsResponse(@PathVariable("index") String index) throws NoSuchAlgorithmException, KeyStoreException, IOException, KeyManagementException {
        log.info(">>> indexExists()");
        GetIndicesSettingsResponse indexSettingsResponse = myService.getIndicesSettingsResponse(index);
        return ResponseEntity.ok(indexSettingsResponse);
    }

    @GetMapping("/index/documentId/{documentId}")
    public ResponseEntity<List<MyDocument>> fetchDocumentByDocumentId(@PathVariable("documentId") String documentId) throws Exception {
        List<MyDocument> myDocuments = myService.fetchDocumentByDocumentId(documentId);
        return ResponseEntity.ok(myDocuments);
    }

    @GetMapping("/index/username/{username}")
    public ResponseEntity<List<MyDocument>> fetchDocumentByUsername(@PathVariable("username") String username) throws RecordNotFoundException, IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        List<MyDocument> myDocuments = myService.fetchDocumentByUsername(username);
        return ResponseEntity.ok(myDocuments);
    }

    @PostMapping("/index/mydocument")
    public ResponseEntity<String> insertMyDocument(@RequestBody MyDocument myDocument) throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        String status = myService.insertDocument(myDocument);
        return ResponseEntity.ok(status);
    }

    @PostMapping("/index/movie")
    public ResponseEntity<String> insertMovie(@RequestBody Movie movie) throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        String status = myService.insertMovie(movie);
        return ResponseEntity.ok(status);
    }

    @PostMapping("/index/bulk")
    public ResponseEntity<String> bulkInsertDocuments(@RequestBody List<MyDocument> myDocuments) throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        boolean isSuccess = myService.bulkInsertDocuments(myDocuments);
        if(isSuccess) {
            return ResponseEntity.ok("Documents successfully ingested!");
        } else {
            return ResponseEntity.internalServerError().body("Oops! unable to ingest data");
        }
    }

    @DeleteMapping("/index/delete/{documentId}")
    public ResponseEntity<String> deleteDocument(@PathVariable("documentId") String documentId) throws Exception {
        String status = myService.deleteDocumentById(documentId);
        return ResponseEntity.ok(status);
    }

    @PutMapping("/index")
    public ResponseEntity<String> updateDocument(@RequestBody MyDocument myDocument) throws IOException {
        String status = myService.updateDocument(myDocument);
        return ResponseEntity.ok(status);
    }

    @GetMapping("/index/movie/{name}")
    public ResponseEntity<List<Movie>> fetchMovieByName(@PathVariable("name") String name) throws Exception {
        List<Movie> movies = myService.fetchMovieByName(name);
        return ResponseEntity.ok(movies);
    }
}
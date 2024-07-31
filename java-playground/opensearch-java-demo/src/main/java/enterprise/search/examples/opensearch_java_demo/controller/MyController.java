package enterprise.search.examples.opensearch_java_demo.controller;

import enterprise.search.examples.opensearch_java_demo.exception.RecordNotFoundException;
import enterprise.search.examples.opensearch_java_demo.model.Employee;
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

    private final MyService employeeService;

    @GetMapping("/index/exists/{index}")
    public ResponseEntity<Boolean> indexExists(@PathVariable("index") String index) throws NoSuchAlgorithmException, KeyStoreException, IOException, KeyManagementException {
        log.info(">>> indexExists()");
        boolean indexExists = employeeService.hasIndex(index);
        return ResponseEntity.ok(indexExists);
    }

    @GetMapping("/index/mapping/{index}")
    public ResponseEntity<GetMappingResponse> getMappingResponse(@PathVariable("index") String index) throws NoSuchAlgorithmException, KeyStoreException, IOException, KeyManagementException {
        log.info(">>> indexExists()");
        GetMappingResponse mappingResponse = employeeService.getMappingResponse(index);
        return ResponseEntity.ok(mappingResponse);
    }

    @GetMapping("/index/settings/{index}")
    public ResponseEntity<GetIndicesSettingsResponse> getIndicesSettingsResponse(@PathVariable("index") String index) throws NoSuchAlgorithmException, KeyStoreException, IOException, KeyManagementException {
        log.info(">>> indexExists()");
        GetIndicesSettingsResponse indexSettingsResponse = employeeService.getIndicesSettingsResponse(index);
        return ResponseEntity.ok(indexSettingsResponse);
    }

    @GetMapping("/index/{id}")
    public ResponseEntity<Employee> fetchEmployeeById(@PathVariable("id") String id) throws RecordNotFoundException, IOException {
        Employee employee = employeeService.fetchEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

    @PostMapping("/index/fetchWithMust")
    public ResponseEntity<List<Employee>> fetchEmployeesWithMustQuery(@RequestBody Employee employeeSearchRequest) throws IOException {
        List<Employee> employees = employeeService.fetchEmployeesWithMustQuery(employeeSearchRequest);
        return ResponseEntity.ok(employees);
    }

    @PostMapping("/index/fetchWithShould")
    public ResponseEntity<List<Employee>> fetchEmployeesWithShouldQuery(@RequestBody Employee employeeSearchRequest) throws IOException {
        List<Employee> employees = employeeService.fetchEmployeesWithShouldQuery(employeeSearchRequest);
        return ResponseEntity.ok(employees);
    }

    @PostMapping("/index")
    public ResponseEntity<String> insertRecords(@RequestBody Employee employee) throws IOException {
        String status = employeeService.insertEmployee(employee);
        return ResponseEntity.ok(status);
    }

    @PostMapping("/index/bulk")
    public ResponseEntity<String> bulkInsertEmployees(@RequestBody List<Employee> employees) throws IOException {
        boolean isSuccess = employeeService.bulkInsertEmployees(employees);
        if(isSuccess) {
            return ResponseEntity.ok("Records successfully ingested!");
        } else {
            return ResponseEntity.internalServerError().body("Oops! unable to ingest data");
        }
    }

    @DeleteMapping("/index/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id) throws IOException {
        String status = employeeService.deleteEmployeeById(id);
        return ResponseEntity.ok(status);
    }

    @PutMapping("/index")
    public ResponseEntity<String> updateEmployee(@RequestBody Employee employee) throws IOException {
        String status = employeeService.updateEmployee(employee);
        return ResponseEntity.ok(status);
    }
}
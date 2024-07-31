package enterprise.search.examples.opensearch_java_demo.service;

import enterprise.search.examples.opensearch_java_demo.connector.ClientConnector;
import enterprise.search.examples.opensearch_java_demo.exception.RecordNotFoundException;
import enterprise.search.examples.opensearch_java_demo.model.Employee;
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
    public Employee fetchEmployeeById(String id) throws RecordNotFoundException, IOException {
        return clientConnector.fetchEmployeeById(id);
    }

    @Override
    public String insertEmployee(Employee employee) throws IOException {
        return clientConnector.insertEmployee(employee);
    }

    @Override
    public boolean bulkInsertEmployees(List<Employee> employees) throws IOException {
        return clientConnector.bulkInsertEmployees(employees);
    }

    @Override
    public List<Employee> fetchEmployeesWithMustQuery(Employee employee) throws IOException {
        return clientConnector.fetchEmployeesWithMustQuery(employee);
    }

    @Override
    public List<Employee> fetchEmployeesWithShouldQuery(Employee employee) throws IOException {
        return clientConnector.fetchEmployeesWithShouldQuery(employee);
    }

    @Override
    public String deleteEmployeeById(Long id) throws IOException {
        return clientConnector.deleteEmployeeById(id);
    }

    @Override
    public String updateEmployee(Employee employee) throws IOException {
        return clientConnector.updateEmployee(employee);
    }
}

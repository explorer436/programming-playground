package enterprise.search.examples.opensearch_java_demo.service;

import enterprise.search.examples.opensearch_java_demo.exception.RecordNotFoundException;
import enterprise.search.examples.opensearch_java_demo.model.Employee;
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

    public Employee fetchEmployeeById(String id) throws RecordNotFoundException, IOException;

    public String insertEmployee(Employee employee) throws IOException;

    public boolean bulkInsertEmployees(List<Employee> employees) throws IOException;

    public List<Employee> fetchEmployeesWithMustQuery(Employee employee) throws IOException;
    public List<Employee> fetchEmployeesWithShouldQuery(Employee employee) throws IOException;

    public String deleteEmployeeById(Long id) throws IOException;

    public String updateEmployee(Employee employee) throws IOException;

}

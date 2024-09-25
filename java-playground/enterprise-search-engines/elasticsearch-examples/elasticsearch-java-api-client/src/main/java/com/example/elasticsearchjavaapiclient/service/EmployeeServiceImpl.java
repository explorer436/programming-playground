package com.example.elasticsearchjavaapiclient.service;

import com.example.elasticsearchjavaapiclient.connector.ClientConnector;
import com.example.elasticsearchjavaapiclient.exception.RecordNotFoundException;
import com.example.elasticsearchjavaapiclient.model.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final ClientConnector clientConnector;

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

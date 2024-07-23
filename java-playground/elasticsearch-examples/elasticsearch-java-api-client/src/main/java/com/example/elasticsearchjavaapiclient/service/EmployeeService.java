package com.example.elasticsearchjavaapiclient.service;

import com.example.elasticsearchjavaapiclient.exception.RecordNotFoundException;
import com.example.elasticsearchjavaapiclient.model.Employee;

import java.io.IOException;
import java.util.List;

public interface EmployeeService {

    public Employee fetchEmployeeById(String id) throws RecordNotFoundException, IOException;

    public String insertEmployee(Employee employee) throws IOException;

    public boolean bulkInsertEmployees(List<Employee> employees) throws IOException;

    public List<Employee> fetchEmployeesWithMustQuery(Employee employee) throws IOException;
    public List<Employee> fetchEmployeesWithShouldQuery(Employee employee) throws IOException;

    public String deleteEmployeeById(Long id) throws IOException;

    public String updateEmployee(Employee employee) throws IOException;

}

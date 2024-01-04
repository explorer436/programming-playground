package com.example.elasticsearchjavaapiclient.controller;

import com.example.elasticsearchjavaapiclient.exception.RecordNotFoundException;
import com.example.elasticsearchjavaapiclient.model.Employee;
import com.example.elasticsearchjavaapiclient.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

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
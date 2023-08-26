package com.example.springaspectorientedprogrammingdemo.controller;

import java.util.List;
import java.util.Map;

import com.example.springaspectorientedprogrammingdemo.entities.Employee;
import com.example.springaspectorientedprogrammingdemo.errorhandling.ResourceNotFoundException;
import com.example.springaspectorientedprogrammingdemo.service.EmployeeService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List <Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity < Employee > getEmployeeById(@PathVariable(value = "id") Long employeeId)
            throws ResourceNotFoundException {
        Employee employee = employeeService.getEmployeeById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
        return ResponseEntity.ok().body(employee);
    }

    @PostMapping("/employees")
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity < Employee > updateEmployee(@PathVariable(value = "id") Long employeeId,
                                                      @Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
        Employee updatedEmployee = employeeService.updateEmployee(employeeId, employeeDetails);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/employees/{id}")
    public Map < String, Boolean > deleteEmployee(@PathVariable(value = "id") Long employeeId)
            throws ResourceNotFoundException {
        return employeeService.deleteEmployee(employeeId);
    }
}

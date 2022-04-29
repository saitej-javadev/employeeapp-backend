package com.saitej.employeeappbackend.controllers;

import com.saitej.employeeappbackend.exceptions.ResourceNotFoundException;
import com.saitej.employeeappbackend.model.Employee;
import com.saitej.employeeappbackend.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
@RestController
public class EmployeeController {

    private final EmployeeService service;


    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return service.getEmployees();
    }

    @PostMapping("/saveEmployee")
    public Employee createEmployee(@RequestBody Employee employee) {
        return service.createEmployee(employee);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) throws ResourceNotFoundException {
        Employee employee = service.getEmployeeById(id);
        return new ResponseEntity < Employee > (employee,HttpStatus.OK);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id , @RequestBody Employee employee) throws ResourceNotFoundException {
        Employee updatedEmployee = service.updateEmployee(id, employee);
        return new ResponseEntity<Employee>(updatedEmployee,HttpStatus.OK);
    }
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable Long id) throws ResourceNotFoundException {
        Map<String, Boolean> response = service.deleteEmployee(id);
        return ResponseEntity.ok(response);


    }
}

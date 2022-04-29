package com.saitej.employeeappbackend.services;

import com.saitej.employeeappbackend.exceptions.ResourceNotFoundException;
import com.saitej.employeeappbackend.model.Employee;
import com.saitej.employeeappbackend.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Employee> getEmployees() {
        return repository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) throws ResourceNotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> (new ResourceNotFoundException("Employee does not exit with id" + id)));

    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) throws ResourceNotFoundException {
        Employee savedEmployee = repository.findById(id)
                .orElseThrow(() -> (new ResourceNotFoundException("Employee does not exit with id" + id)));
        savedEmployee.setFirstName(employee.getFirstName());
        savedEmployee.setLastName(employee.getLastName());
        savedEmployee.setEmailId(employee.getEmailId());
        savedEmployee.setSalary(employee.getSalary());
        return repository.save(savedEmployee);
    }

    @Override
    public Map<String, Boolean> deleteEmployee(Long id) throws ResourceNotFoundException {
        Employee savedEmployee = repository.findById(id)
                .orElseThrow(() -> (new ResourceNotFoundException("Employee does not exit with id" + id)));
        repository.delete(savedEmployee);
        Map<String,Boolean> response = new HashMap<>();
        response.put("Deleted",Boolean.TRUE);
        return response;
    }


    @Override
    public Employee createEmployee(Employee employee) {
        return repository.save(employee);
    }
}

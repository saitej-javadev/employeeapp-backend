package com.saitej.employeeappbackend.services;

import com.saitej.employeeappbackend.exceptions.ResourceNotFoundException;
import com.saitej.employeeappbackend.model.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    Employee createEmployee(Employee employee);
    public List<Employee> getEmployees();
    public Employee getEmployeeById(Long id) throws ResourceNotFoundException;
    public Employee updateEmployee(Long id, Employee employee) throws ResourceNotFoundException;
    public Map<String,Boolean> deleteEmployee(Long id) throws ResourceNotFoundException;



}

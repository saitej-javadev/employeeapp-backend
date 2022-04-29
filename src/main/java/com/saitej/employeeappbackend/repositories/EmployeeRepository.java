package com.saitej.employeeappbackend.repositories;

import com.saitej.employeeappbackend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}

package com.saitej.employeeappbackend.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "EMPLOYEEAPP_TBL")
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name",nullable = false)
    private String firstName;
    @Column(name = "second_name")
    private String lastName;
    @Column(name = "email_id")
    private String emailId;
    private double salary;


    public Employee(String firstName, String lastName, String emailId, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.salary = salary;
    }
}

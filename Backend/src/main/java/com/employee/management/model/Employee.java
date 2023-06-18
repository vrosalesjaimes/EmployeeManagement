package com.employee.management.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name", nullable = false, length =60)
    private String firstName;
    @Column(name = "last_name", nullable = false, length =60)
    private String lastName;
    @Column(name = "email", nullable = false, length =200, unique = true)
    private String email;


    public Employee(Long id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Employee(){}
}

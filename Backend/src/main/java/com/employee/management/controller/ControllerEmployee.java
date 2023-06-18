package com.employee.management.controller;

import com.employee.management.model.Employee;
import com.employee.management.repository.RepositoryEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class ControllerEmployee {
    @Autowired
    private RepositoryEmployee repositoryEmployee;

    @GetMapping("/employees")
    public List<Employee> allEmployees() {
        return repositoryEmployee.findAll();
    }
}

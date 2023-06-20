package com.employee.management.controller;

import com.employee.management.exceptions.ResourceNotFoundException;
import com.employee.management.model.Employee;
import com.employee.management.repository.RepositoryEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("api/v1/")
@CrossOrigin(origins = "http://localhost:4200/")
public class ControllerEmployee {
    @Autowired
    private RepositoryEmployee repositoryEmployee;

    @GetMapping("/employees")
    public List<Employee> allEmployees() {
        return repositoryEmployee.findAll();
    }

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee){
        return repositoryEmployee.save(employee);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        Employee employee = repositoryEmployee.findById(id)
                            .orElseThrow(() -> new ResourceNotFoundException("No existe el empleado"));
        return ResponseEntity.ok(employee);

    }

    @PutMapping(value="/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee newData){
        Employee employee = repositoryEmployee.findById(id)
                            .orElseThrow(() -> new ResourceNotFoundException("No existe el empleado"));
        employee.setFirstName(newData.getFirstName());
        employee.setLastName(newData.getLastName());
        employee.setEmail(newData.getEmail());

        Employee updateEmployee = repositoryEmployee.save(employee);
        return ResponseEntity.ok(updateEmployee);
    }

    @DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String,Boolean>> eliminarEmpleado(@PathVariable Long id){
		Employee empleado = repositoryEmployee.findById(id)
				            .orElseThrow(() -> new ResourceNotFoundException("No existe el empleado con el ID : " + id));
		
		repositoryEmployee.delete(empleado);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar",Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
    }
}

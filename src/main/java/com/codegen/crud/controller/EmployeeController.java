package com.codegen.crud.controller;

import com.codegen.crud.exception.ResourceNotFoundException;
import com.codegen.crud.model.Employee;
import com.codegen.crud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.Format;
import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController
{
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeByID( @PathVariable Long id ) {

        Employee employee = employeeRepository.findById(id)
                                              .orElseThrow(() -> new ResourceNotFoundException( String.format( "An Employee With The ID %s Does Not Exist", id ) ) );
        return ResponseEntity.ok(employee);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, Employee employeeDetails) {
        Employee employee = employeeRepository.findById(id)
                                              .orElseThrow(() -> new ResourceNotFoundException( String.format( "An Employee With The ID %s Does Not Exist", id ) ) );

        employee.setfName( employeeDetails.getfName() );
        employee.setlName( employeeDetails.getlName() );
        employee.setEmailID( employeeDetails.getEmailID() );

        Employee updatedEmployee = employeeRepository.save( employee );
        return ResponseEntity.ok(updatedEmployee);
    }

}

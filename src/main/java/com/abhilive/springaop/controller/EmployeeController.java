package com.abhilive.springaop.controller;


import com.abhilive.springaop.entity.Employee;
import com.abhilive.springaop.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/all")
    public ResponseEntity<?> fetchAllEmployees() {
        return new ResponseEntity<List<Employee>>(employeeService.getAllEmps(), HttpStatus.OK);
    }

    @GetMapping("/add")
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<Employee>(employeeService.save(employee), HttpStatus.CREATED);
    }
}

package com.techm.h2database.sample.controller;

import com.techm.h2database.sample.entity.Employee;
import com.techm.h2database.sample.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/saveEmployee")
    public Employee saveEmployee() {
        return employeeService.saveOrUpdate();


    }
/*
    @GetMapping("/getAllEmployees")
    public List<Employee> getAll() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employee/{id}")
    private Employee getStudent(@PathVariable("id") int id) {
        return employeeService.getStudentById(id);
    }*/
}

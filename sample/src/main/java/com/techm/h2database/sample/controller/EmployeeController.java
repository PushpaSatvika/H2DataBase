package com.techm.h2database.sample.controller;

import com.techm.h2database.sample.entity.Employee;
import com.techm.h2database.sample.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/saveEmployee")
    public List<Employee> saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveOrUpdate(employee);

    }
    @GetMapping("/getAllEmployees")
    public List<Employee> getAll() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employee/{id}")
    private Employee getStudent(@PathVariable("id") int id) {
        return employeeService.getStudentById(id);
    }
}

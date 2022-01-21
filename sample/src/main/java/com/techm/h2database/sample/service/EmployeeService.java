package com.techm.h2database.sample.service;

import com.techm.h2database.sample.entity.Employee;
import com.techm.h2database.sample.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Value("${employee.employeeList.details}")
    private String stringList;

    public Employee map() {
        String[] tokens = stringList.split(",");
        Employee result = new Employee(Integer.parseInt(tokens[0]),
                tokens[1]);


        return result;
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        employeeRepository.findAll().forEach(employee -> employees.add(employee));
        return employees;
    }

    public Employee getStudentById(int id) {
        return employeeRepository.findById(id).get();
    }

    public Employee saveOrUpdate() {
        Employee employees = map();
        return employeeRepository.save(employees);

    }

}

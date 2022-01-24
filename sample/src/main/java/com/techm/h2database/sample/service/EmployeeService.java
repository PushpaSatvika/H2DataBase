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
    private List<String> employeeNameList;

    public List<Employee> stringListToEmployeeListConversion() {
        List<Employee> employeeList = new ArrayList<>();
        for (String s : employeeNameList) {
            Employee e = new Employee();
            e.setName(s);
            employeeList.add(e);
        }
        return employeeList;
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        employeeRepository.findAll().forEach(employee -> employees.add(employee));
        return employees;
    }

    public Employee getStudentById(int id) {
        return employeeRepository.findById(id).get();
    }

    public List<Employee> saveOrUpdate(Employee employee) {
        List<Employee> employeeList = stringListToEmployeeListConversion();
        List<Employee> employeeList1 = new ArrayList<>();
        for (Employee e : employeeList
        ) {
            employeeList1.add(employeeRepository.save(e));
        }
        employeeList1.add(employeeRepository.save(employee));
        return employeeList1;
    }

}

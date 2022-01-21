package com.techm.h2database.sample.repository;

import com.techm.h2database.sample.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}

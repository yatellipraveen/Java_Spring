package com.example.employeedirectory.dao;

import com.example.employeedirectory.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // that's it ... no need to write any code!
}

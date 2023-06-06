package com.example.employeedirectory.service;

import com.example.employeedirectory.dao.EmployeeRepository;
import com.example.employeedirectory.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository){
        employeeRepository = theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int Id) {
        Optional<Employee> result = employeeRepository.findById(Id);
        Employee employee = null;

        if(result.isPresent()){
            employee = result.get();
        }
        else {
            //we didnt find the employee
            throw new RuntimeException("Did not find employee id - " + Id);
        }
        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteById(int Id) {
        employeeRepository.deleteById(Id);
    }
}

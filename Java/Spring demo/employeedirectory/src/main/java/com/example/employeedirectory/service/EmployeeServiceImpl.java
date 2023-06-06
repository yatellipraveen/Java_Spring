package com.example.employeedirectory.service;

import com.example.employeedirectory.dao.EmployeeDAO;
import com.example.employeedirectory.dao.EmployeeDAOJpaImpl;
import com.example.employeedirectory.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO theEmployee){
        employeeDAO = theEmployee;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int Id) {
        return employeeDAO.findById(Id);
    }

    @Transactional
    @Override
    public Employee save(Employee employee) {
        return employeeDAO.save(employee);
    }

    @Transactional
    @Override
    public void deleteById(int Id) {
        employeeDAO.deleteById(Id);
    }
}

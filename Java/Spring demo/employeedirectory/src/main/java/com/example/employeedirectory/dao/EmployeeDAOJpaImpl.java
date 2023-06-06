package com.example.employeedirectory.dao;

import com.example.employeedirectory.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{
    //define field for entitymanager
    private EntityManager entityManager;

    //set up constructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {
        //crete a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);
        //execute query and get result list
        List<Employee> employees = theQuery.getResultList();

        //return the results
        return employees;
    }

    @Override
    public Employee findById(int Id) {
        //get employee
        Employee theEmployee = entityManager.find(Employee.class, Id);

        //return employee
        return theEmployee;
    }

    @Override
    public Employee save(Employee employee) {
        //save employee
        Employee dbEmployee = entityManager.merge(employee);

        //return employee
        return dbEmployee;
    }

    @Override
    public void deleteById(int Id) {
        // find employee by id
        Employee employee = entityManager.find(Employee.class, Id);

        //remove employee
        entityManager.remove(employee);
    }
}

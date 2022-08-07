package com.example.rest_crud_api_employee.service;

import com.example.rest_crud_api_employee.entity.Employee;

import java.util.List;

public interface EmployeeServicce {

    // Get all Employees
    public List<Employee> findAll() ;

    // Find Employee by ID
    public Employee findByID(int ID) ;

    // Save a new Employee
    public void save(Employee employee) ;

    // delete Employee
    public void deleteByID(int ID) ;

}

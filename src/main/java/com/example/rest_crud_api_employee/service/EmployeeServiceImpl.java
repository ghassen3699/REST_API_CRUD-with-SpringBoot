package com.example.rest_crud_api_employee.service;

import com.example.rest_crud_api_employee.dao.EmployeeDAO;
import com.example.rest_crud_api_employee.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeServicce{

    private EmployeeDAO employeeDAO ;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO) {
        employeeDAO = theEmployeeDAO;
    }

    @Override
    @Transactional
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    @Transactional
    public Employee findByID(int ID) {
        return employeeDAO.findByID(ID);
    }

    @Override
    @Transactional
    public void save(Employee employee) {
        employeeDAO.save(employee);
    }

    @Override
    @Transactional
    public void deleteByID(int ID) {
        employeeDAO.deleteByID(ID);
    }
}

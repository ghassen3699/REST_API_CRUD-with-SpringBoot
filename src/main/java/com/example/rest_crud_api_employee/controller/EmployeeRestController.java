package com.example.rest_crud_api_employee.controller;


import com.example.rest_crud_api_employee.entity.Employee;
import com.example.rest_crud_api_employee.service.EmployeeServicce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeServicce employeeServicce ;

    @Autowired
    public EmployeeRestController(EmployeeServicce theEmployeeServicce) {
        employeeServicce = theEmployeeServicce;
    }


    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeServicce.findAll() ;
    }

    @GetMapping("/employee/{id}")
    public Employee getSingleEmployee(@PathVariable int id){
        Employee theEmployee =  employeeServicce.findByID(id) ;
        if(theEmployee == null){
            throw new RuntimeException("Employee id not found - " + id) ;
        }
        return theEmployee ;
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee theEmployee){

        theEmployee.setID(0);
        employeeServicce.save(theEmployee);
        return theEmployee ;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        employeeServicce.save(theEmployee);
        return theEmployee ;
    }

    @DeleteMapping("/employee/{employeeID}")
    public String deleteEmployee(@PathVariable int employeeID){
        Employee theEmployee = employeeServicce.findByID(employeeID) ;
        if (theEmployee == null){
            throw new RuntimeException("Employee not Found") ;
        }
        employeeServicce.deleteByID(employeeID);
        return "Employee Deleted With Success" ;
    }




}

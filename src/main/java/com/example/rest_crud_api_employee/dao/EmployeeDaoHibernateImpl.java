package com.example.rest_crud_api_employee.dao;

import com.example.rest_crud_api_employee.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDaoHibernateImpl implements EmployeeDAO{

    private EntityManager entityManager ;

    @Autowired
    public EmployeeDaoHibernateImpl(EntityManager theEntityManager){
        entityManager = theEntityManager ;
    }


    @Override
    public List<Employee> findAll() {

        // Get the current hibernate
        Session currentSession = entityManager.unwrap(Session.class);

        // Create a query
        Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class) ;
        List<Employee> employees = theQuery.getResultList() ;

        // Execute query

        // Return the result
        return employees;
    }


    @Override
    public Employee findByID(int ID) {

        // Get the current Hibernate Session
        Session currentSession = entityManager.unwrap(Session.class) ;

        // Get the employee
        Employee employee = currentSession.get(Employee.class, ID) ;

        // return the employee
        return employee;
    }

    @Override
    public void save(Employee employee) {
        Session currentSession = entityManager.unwrap(Session.class) ;

        currentSession.saveOrUpdate(employee);
    }

    @Override
    public void deleteByID(int ID) {
        Session currentSession = entityManager.unwrap(Session.class) ;
        Query theQuery = currentSession.createQuery("delete from Employee where ID =:employeeID");
        theQuery.setParameter("employeeID",ID);
        theQuery.executeUpdate();
    }


}

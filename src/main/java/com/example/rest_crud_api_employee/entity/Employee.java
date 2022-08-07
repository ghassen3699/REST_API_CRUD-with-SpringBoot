package com.example.rest_crud_api_employee.entity;


import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int ID ;
    @Column(name = "FIRST_NAME")
    private String FIRST_NAME ;
    @Column(name = "LAST_NAME")
    private String LAST_NAME ;
    @Column(name = "EMAIL")
    private String EMAIL ;


    public Employee(String FIRST_NAME, String LAST_NAME, String EMAIL) {
        this.FIRST_NAME = FIRST_NAME;
        this.LAST_NAME = LAST_NAME;
        this.EMAIL = EMAIL;
    }

    public Employee() {

    }


    public int getID() {
        return ID;
    }

    public String getFIRST_NAME() {
        return FIRST_NAME;
    }

    public String getLAST_NAME() {
        return LAST_NAME;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setFIRST_NAME(String FIRST_NAME) {
        this.FIRST_NAME = FIRST_NAME;
    }

    public void setLAST_NAME(String LAST_NAME) {
        this.LAST_NAME = LAST_NAME;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "ID=" + ID +
                ", FIRST_NAME='" + FIRST_NAME + '\'' +
                ", LAST_NAME='" + LAST_NAME + '\'' +
                ", EMAIL='" + EMAIL + '\'' +
                '}';
    }
}

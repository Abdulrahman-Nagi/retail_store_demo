package com.ups.retailstore.entity;



import javax.persistence.*;


@Entity
@Table(name = "retail_employee")
public class RetailEmployee extends User {



    @Column(name = "employee_salary")
    private int salary;







}

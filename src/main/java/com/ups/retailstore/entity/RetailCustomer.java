package com.ups.retailstore.entity;


import javax.persistence.*;


@Entity
@Table(name = "retail_customer")
public class RetailCustomer extends User {


    @Column(name = "customer_address")
    private String customerAddress;






}

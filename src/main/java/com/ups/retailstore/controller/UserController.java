package com.ups.retailstore.controller;

import com.ups.retailstore.entity.RetailCustomer;
import com.ups.retailstore.entity.RetailEmployee;
import com.ups.retailstore.entity.User;
import com.ups.retailstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/register/")
public class UserController {


    @Autowired
    UserService userService;



    @PostMapping(value = "/employee")
    ResponseEntity<RetailEmployee> employeeRegister(@RequestBody RetailEmployee employee) {

        userService.saveNewUser(employee);

        return new ResponseEntity<RetailEmployee>(HttpStatus.CREATED);
    }



    @PostMapping(value = "/customer")
    ResponseEntity<RetailCustomer> employeeRegister(@RequestBody RetailCustomer customer) {

        userService.saveNewUser(customer);

        return new ResponseEntity<RetailCustomer>(HttpStatus.CREATED);
    }

}

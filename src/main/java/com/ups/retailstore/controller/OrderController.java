package com.ups.retailstore.controller;

import com.ups.retailstore.entity.Discount;
import com.ups.retailstore.service.RetailOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders/")
public class OrderController {


    @Autowired
    RetailOrderService retailOrderService;




    @GetMapping(value = "/discount")
    ResponseEntity<Discount> getDiscount() {


        Discount discount = retailOrderService.getDiscount();


        return new ResponseEntity<Discount>(discount,HttpStatus.OK);
    }
}

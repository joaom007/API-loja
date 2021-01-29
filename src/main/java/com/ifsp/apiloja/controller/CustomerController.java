package com.ifsp.apiloja.controller;

import java.util.List;

import com.ifsp.apiloja.model.Customer;
import com.ifsp.apiloja.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/cliente")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping
    public ResponseEntity<List<Customer>> selectCustomer(){
        List<Customer> list = service.selectCustomer();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Customer> selectCustomerById(@PathVariable Long id) {
        Customer obj = service.selectCustomerById(id);
        return ResponseEntity.ok().body(obj);
    }

}

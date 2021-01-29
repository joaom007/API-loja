package com.ifsp.apiloja.service;

import java.util.List;
import java.util.Optional;

import com.ifsp.apiloja.model.Customer;
import com.ifsp.apiloja.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public List<Customer> selectCustomer() {
        return repository.findAll();
    }
    
    public Customer selectCustomerById(Long id) {
      Optional<Customer> obj = repository.findById(id);
      return obj.get();
    }
}

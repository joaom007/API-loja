package com.ifsp.apiloja.service;

import java.util.List;
import java.util.Optional;

import com.ifsp.apiloja.model.Customer;
import com.ifsp.apiloja.repository.CustomerRepository;
import com.ifsp.apiloja.service.exception.ResourceNotFoundException;

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
      return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Customer insert(Customer obj) {
      return repository.save(obj);
    }

    public void delete(Long id) {
      repository.deleteById(id);
    }

    public Customer update(Long id, Customer obj) {
      Customer model = repository.getOne(id);
      updateData(model, obj);
      return repository.save(model);
    }

    private void updateData(Customer model, Customer obj) {
      model.setName(obj.getName());
      model.setCpf(obj.getCpf());
      model.setRg(obj.getRg());
      model.setEmail(obj.getEmail());
      model.setPassword(obj.getPassword());
      model.setDateBirth(obj.getDateBirth());
    }

}

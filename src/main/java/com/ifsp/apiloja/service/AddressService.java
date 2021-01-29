package com.ifsp.apiloja.service;

import java.util.List;
import java.util.Optional;

import com.ifsp.apiloja.model.Address;
import com.ifsp.apiloja.repository.AddressRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddressRepository repository;

    public List<Address> selectAddress() {
        return repository.findAll();
    }
    
    public Address selectAddressById(Long id) {
      Optional<Address> obj = repository.findById(id);
      return obj.get();
    }
}

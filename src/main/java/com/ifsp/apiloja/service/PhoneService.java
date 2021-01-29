package com.ifsp.apiloja.service;

import java.util.List;
import java.util.Optional;

import com.ifsp.apiloja.model.Phone;
import com.ifsp.apiloja.repository.PhoneRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhoneService {

    @Autowired
    private PhoneRepository repository;

    public List<Phone> selectPhone() {
        return repository.findAll();
    }
    
    public Phone selectPhoneById(Long id) {
      Optional<Phone> obj = repository.findById(id);
      return obj.get();
    }
}

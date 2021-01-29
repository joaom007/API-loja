package com.ifsp.apiloja.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.ifsp.apiloja.model.Address;
import com.ifsp.apiloja.repository.AddressRepository;
import com.ifsp.apiloja.service.exception.DataBaseException;
import com.ifsp.apiloja.service.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
      return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Address insert(Address obj) {
      return repository.save(obj);
    }

    public void delete(Long id) {
      try {
        repository.deleteById(id);

      } catch (EmptyResultDataAccessException e) {
        throw new ResourceNotFoundException(id);
        
      } catch (DataIntegrityViolationException e){
        throw new DataBaseException(e.getMessage());
      }
    }

    public Address update(Long id, Address obj) {
      try {
        Address model = repository.getOne(id);
        updateData(model, obj);
        return repository.save(model);
      } catch (EntityNotFoundException e) {
        throw new ResourceNotFoundException(id);
      }
      
    }

    private void updateData(Address model, Address obj) {
      model.setStreet(obj.getStreet());
      model.setNumber(obj.getNumber());
      model.setDistrict(obj.getDistrict());
      model.setCity(obj.getCity());
      model.setState(obj.getState());
      model.setZipCode(obj.getZipCode());      
    }

}

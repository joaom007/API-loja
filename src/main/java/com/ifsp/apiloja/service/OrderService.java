package com.ifsp.apiloja.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.ifsp.apiloja.model.Order;
import com.ifsp.apiloja.repository.OrderRepository;
import com.ifsp.apiloja.service.exception.DataBaseException;
import com.ifsp.apiloja.service.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public List<Order> selectOrder() {
        return repository.findAll();
    }
    
    public Order selectOrderById(Long id) {
      Optional<Order> obj = repository.findById(id);
      return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public List<Order> selectOrderByCustomer(Long id) {
      return repository.selectOrderByCustomer(id); 
    }

    public Order insert(Order obj) {
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

    public Order update(Long id, Order obj) {
      try {
        Order model = repository.getOne(id);
        updateData(model, obj);
        return repository.save(model);
      } catch (EntityNotFoundException e) {
        throw new ResourceNotFoundException(id);
      }
    }

    private void updateData(Order model, Order obj) {
      model.setDate(obj.getDate());
      model.setPaymentForm(obj.getPaymentForm());
      model.setStatus(obj.getStatus());
    }
}

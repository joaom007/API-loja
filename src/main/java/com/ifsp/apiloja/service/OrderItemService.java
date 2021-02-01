package com.ifsp.apiloja.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.ifsp.apiloja.model.OrderItem;
import com.ifsp.apiloja.repository.OrderItemRepository;
import com.ifsp.apiloja.service.exception.DataBaseException;
import com.ifsp.apiloja.service.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository repository;

    public List<OrderItem> selectOrderItem() {
        return repository.findAll();
    }
    
    public OrderItem selectOrderItemById(Long id) {
      Optional<OrderItem> obj = repository.findById(id);
      return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }
    
    public List<OrderItem> selectOrderItemByCustomer(Long id) {
      return repository.selectOrderItemByCustomer(id); 
    }

    public OrderItem insert(OrderItem obj) {
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

    public OrderItem update(Long id, OrderItem obj) {
      try {
        OrderItem model = repository.getOne(id);
        updateData(model, obj);
        return repository.save(model);
      } catch (EntityNotFoundException e) {
        throw new ResourceNotFoundException(id);
      }
    }

    private void updateData(OrderItem model, OrderItem obj) {
      model.setPrice(obj.getPrice());
      model.setQuantity(obj.getQuantity());
    }
}

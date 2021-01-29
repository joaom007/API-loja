package com.ifsp.apiloja.service;

import java.util.List;
import java.util.Optional;

import com.ifsp.apiloja.model.Order;
import com.ifsp.apiloja.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
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
      return obj.get();
    }
}

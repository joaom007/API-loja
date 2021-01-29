package com.ifsp.apiloja.repository;

import com.ifsp.apiloja.model.OrderItem;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
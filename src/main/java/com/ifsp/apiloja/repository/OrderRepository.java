package com.ifsp.apiloja.repository;

import com.ifsp.apiloja.model.Order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
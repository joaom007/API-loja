package com.ifsp.apiloja.repository;

import java.util.List;

import com.ifsp.apiloja.model.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<Order, Long>{

    @Query("select u from Order u where u.customer.id = :id")
    List<Order> selectOrderByCustomer(Long id);
}
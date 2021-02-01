package com.ifsp.apiloja.repository;

import java.util.List;

import com.ifsp.apiloja.model.OrderItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

    @Query("select u from OrderItem u where u.order.id = :id")
    List<OrderItem> selectOrderItemByCustomer(Long id);

}
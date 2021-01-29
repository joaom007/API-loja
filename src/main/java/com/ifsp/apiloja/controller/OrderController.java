package com.ifsp.apiloja.controller;

import java.util.List;

import com.ifsp.apiloja.model.Order;
import com.ifsp.apiloja.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/pedido")
public class OrderController {

    @Autowired
    private OrderService service;

    @GetMapping
    public ResponseEntity<List<Order>> selectOrder(){
        List<Order> list = service.selectOrder();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> selectOrderById(@PathVariable Long id) {
        Order obj = service.selectOrderById(id);
        return ResponseEntity.ok().body(obj);
    }

}

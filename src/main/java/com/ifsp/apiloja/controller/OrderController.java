package com.ifsp.apiloja.controller;

import java.net.URI;
import java.util.List;

import com.ifsp.apiloja.model.Order;
import com.ifsp.apiloja.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
    //Select *
    //Return default cod 200 http
    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> selectOrderById(@PathVariable Long id) {
        Order obj = service.selectOrderById(id);
        return ResponseEntity.ok().body(obj);
    }

    //Select by id
    //Return cod 201 http
    @PostMapping
    public ResponseEntity<Order> insert(@RequestBody Order obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    //Delete by id
    //Return cod 204 http
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    //Update by id
    //Return default cod 200 http
    @PutMapping(value = "/{id}")
    public ResponseEntity<Order> update(@PathVariable Long id, @RequestBody Order obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

}

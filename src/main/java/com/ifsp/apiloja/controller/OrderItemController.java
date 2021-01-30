package com.ifsp.apiloja.controller;

import java.net.URI;
import java.util.List;

import com.ifsp.apiloja.model.OrderItem;
import com.ifsp.apiloja.service.OrderItemService;

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
@RequestMapping(path = "/api/pedido/item")
public class OrderItemController {

    @Autowired
    private OrderItemService service;

    @GetMapping
    public ResponseEntity<List<OrderItem>> selectOrderItem(){
        List<OrderItem> list = service.selectOrderItem();
        return ResponseEntity.ok().body(list);
    }
    //Select *
    //Return default cod 200 http
    @GetMapping(value = "/{id}")
    public ResponseEntity<OrderItem> selectOrderItemById(@PathVariable Long id) {
        OrderItem obj = service.selectOrderItemById(id);
        return ResponseEntity.ok().body(obj);
    }

    // @GetMapping(value = "/{id}")
    // public ResponseEntity<OrderItem> selectOrderItemById(@PathVariable Order id) {
    //     OrderItem obj = service.selectOrderItemById(id);
    //     return ResponseEntity.ok().body(obj);
    // }

    //Select by id
    //Return cod 201 http
    @PostMapping
    public ResponseEntity<OrderItem> insert(@RequestBody OrderItem obj) {
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
    public ResponseEntity<OrderItem> update(@PathVariable Long id, @RequestBody OrderItem obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

}

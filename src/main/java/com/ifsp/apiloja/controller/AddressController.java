package com.ifsp.apiloja.controller;

import java.util.List;

import com.ifsp.apiloja.model.Address;
import com.ifsp.apiloja.service.AddressService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/endereco")
public class AddressController {

    @Autowired
    private AddressService service;

    @GetMapping
    public ResponseEntity<List<Address>> selectAddress(){
        List<Address> list = service.selectAddress();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Address> selectAddressById(@PathVariable Long id) {
        Address obj = service.selectAddressById(id);
        return ResponseEntity.ok().body(obj);
    }

}

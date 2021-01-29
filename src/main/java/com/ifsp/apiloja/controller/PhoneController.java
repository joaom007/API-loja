package com.ifsp.apiloja.controller;

import java.util.List;

import com.ifsp.apiloja.model.Phone;
import com.ifsp.apiloja.service.PhoneService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/telefone")
public class PhoneController {

    @Autowired
    private PhoneService service;

    @GetMapping
    public ResponseEntity<List<Phone>> selectPhone(){
        List<Phone> list = service.selectPhone();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Phone> selectPhoneById(@PathVariable Long id) {
        Phone obj = service.selectPhoneById(id);
        return ResponseEntity.ok().body(obj);
    }

}

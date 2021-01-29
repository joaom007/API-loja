package com.ifsp.apiloja.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

    @GetMapping(value="/")
    public String getMethodName() {
        return "IFSP API 1 - Loja de Livros";
    }
    
    
}

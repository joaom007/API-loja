package com.ifsp.apiloja.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloControler {

    @GetMapping(value="/")
    public String getMethodName() {
        return "Hello Wolrd !!!";
    }
    
    
}

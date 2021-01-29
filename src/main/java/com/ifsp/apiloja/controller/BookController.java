package com.ifsp.apiloja.controller;

import java.util.List;

import com.ifsp.apiloja.model.Book;
import com.ifsp.apiloja.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/livro")
public class BookController {

    @Autowired
    private BookService service;

    @GetMapping
    public ResponseEntity<List<Book>> selectBook(){
        List<Book> list = service.selectBook();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Book> selectBookById(@PathVariable Long id) {
        Book obj = service.selectBookById(id);
        return ResponseEntity.ok().body(obj);
    }

}

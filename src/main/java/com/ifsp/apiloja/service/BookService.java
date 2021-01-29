package com.ifsp.apiloja.service;

import java.util.List;
import java.util.Optional;

import com.ifsp.apiloja.model.Book;
import com.ifsp.apiloja.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public List<Book> selectBook() {
        return repository.findAll();
    }
    
    public Book selectBookById(Long id) {
      Optional<Book> obj = repository.findById(id);
      return obj.get();
    }
}

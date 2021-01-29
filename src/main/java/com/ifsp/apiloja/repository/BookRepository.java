package com.ifsp.apiloja.repository;

import com.ifsp.apiloja.model.Book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long>{

}

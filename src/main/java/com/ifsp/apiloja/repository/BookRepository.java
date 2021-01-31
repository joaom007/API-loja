package com.ifsp.apiloja.repository;

import java.util.List;

import com.ifsp.apiloja.model.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book, Long>{

    @Query("select u from Book u where u.category.id = :id")
    List<Book> selectBookByCategory(Long id);

}

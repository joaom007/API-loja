package com.ifsp.apiloja.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.ifsp.apiloja.model.Book;
import com.ifsp.apiloja.repository.BookRepository;
import com.ifsp.apiloja.service.exception.DataBaseException;
import com.ifsp.apiloja.service.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
      return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Book insert(Book obj) {
      return repository.save(obj);
    }

    public void delete(Long id) {
      try {
        repository.deleteById(id);

      } catch (EmptyResultDataAccessException e) {
        throw new ResourceNotFoundException(id);
        
      } catch (DataIntegrityViolationException e){
        throw new DataBaseException(e.getMessage());
      }
    }

    public Book update(Long id, Book obj) {
      try {
        Book model = repository.getOne(id);
        updateData(model, obj);
        return repository.save(model);
      } catch (EntityNotFoundException e) {
        throw new ResourceNotFoundException(id);
      }
      
    }

    private void updateData(Book model, Book obj) {
      model.setAuthor(obj.getAuthor());
      model.setTitle(obj.getTitle());
      model.setIsbn(obj.getIsbn());
      model.setPublisher(obj.getPublisher());
      model.setCity(obj.getCity());
      model.setEdition(obj.getEdition());
      model.setYear(obj.getYear());
      model.setPages(obj.getPages());
      model.setUnitaryValue(obj.getUnitaryValue());
      model.setDescription(obj.getDescription());
      model.setCategory(obj.getCategory());

    }

}

package com.ifsp.apiloja.service;

import java.util.List;
import java.util.Optional;

import com.ifsp.apiloja.model.Category;
import com.ifsp.apiloja.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> selectCategory() {
        return repository.findAll();
    }
    
    public Category selectCategoryById(Long id) {
      Optional<Category> obj = repository.findById(id);
      return obj.get();
    }
}

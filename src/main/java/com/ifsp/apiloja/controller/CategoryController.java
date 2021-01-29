package com.ifsp.apiloja.controller;

import java.util.List;

import com.ifsp.apiloja.model.Category;
import com.ifsp.apiloja.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/categoria")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping
    public ResponseEntity<List<Category>> selectCategory(){
        List<Category> list = service.selectCategory();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> selectCategoryById(@PathVariable Long id) {
        Category obj = service.selectCategoryById(id);
        return ResponseEntity.ok().body(obj);
    }


    // @Autowired
    // private CategoryRepository categoryRepository;

    // @GetMapping
    // public Iterable<Category> selectCategory() {
    //     return categoryRepository.findAll();
    // }

    
    // @PostMapping
    // public @ResponseBody Category insertCategory(Category cat) {
    //     // Category cat = new Category(category);
    //     categoryRepository.save(cat);
    //     return cat;
    // }

    // @PutMapping
    // public Category updateCategory(Category cat) {
    //     // Category cat = new Category(idCategory,category);
    //     categoryRepository.save(cat);
    //     return cat;
    // }
}

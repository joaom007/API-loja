package com.ifsp.apiloja.repository;

import com.ifsp.apiloja.model.Category;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}

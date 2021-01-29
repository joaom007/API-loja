package com.ifsp.apiloja.config;

import java.util.Arrays;

import com.ifsp.apiloja.model.Category;
import com.ifsp.apiloja.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
 
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        
        Category c1 = new Category(null, "teste1");
        Category c2 = new Category(null, "teste2");

        categoryRepository.saveAll(Arrays.asList(c1,c2));
        
    }
}

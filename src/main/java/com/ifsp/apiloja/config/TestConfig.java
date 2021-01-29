package com.ifsp.apiloja.config;

import java.util.Arrays;

import com.ifsp.apiloja.model.Book;
import com.ifsp.apiloja.model.Category;
import com.ifsp.apiloja.repository.BookRepository;
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

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        
        Category c1 = new Category(null, "teste1");
        Category c2 = new Category(null, "teste2");

        Book b1 = new Book(null, "maria", "A rede de Alice", "98754879", "Érica", "São Paulo", "2°", "2015", "380", 35.99, "description", c1);
        Book b2 = new Book(null, "maria", "A rede de Alice", "98754879", "Érica", "São Paulo", "2", "2015", "380", 35.99, "description", c2);

        categoryRepository.saveAll(Arrays.asList(c1,c2));
        bookRepository.saveAll(Arrays.asList(b1,b2));       
    }
}

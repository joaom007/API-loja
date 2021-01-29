package com.ifsp.apiloja.config;

import java.util.Arrays;

import com.ifsp.apiloja.model.Address;
import com.ifsp.apiloja.model.Book;
import com.ifsp.apiloja.model.Category;
import com.ifsp.apiloja.model.Customer;
import com.ifsp.apiloja.model.Phone;
import com.ifsp.apiloja.repository.AddressRepository;
import com.ifsp.apiloja.repository.BookRepository;
import com.ifsp.apiloja.repository.CategoryRepository;
import com.ifsp.apiloja.repository.CustomerRepository;
import com.ifsp.apiloja.repository.PhoneRepository;

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

    @Autowired
    private PhoneRepository phoneRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {
        
        Category c1 = new Category(null, "teste1");
        Category c2 = new Category(null, "teste2");

        Book b1 = new Book(null, "maria", "A rede de Alice", "98754879", "Érica", "São Paulo", "2°", "2015", "380", 35.99, "description", c1);
        Book b2 = new Book(null, "maria", "A rede de Alice", "98754879", "Érica", "São Paulo", "2", "2015", "380", 35.99, "description", c2);

        Customer ct1 = new Customer(null, "João", "999.888.777-66", "99.888.777-6", "testando@hotmail.com", "password", "ashduasjdas", "25/03/1997");

        Customer ct2 = new Customer(null, "João", "111.222.333-44", "11.222.333-4", "teste@teste.com", "457895", "aksdhnsajdh", "25/02/2019");

        Phone ph1 = new Phone(null, "11999998888", ct1);
        Phone ph2 = new Phone(null, "11999998888", ct1);
        Phone ph3 = new Phone(null, "11999998888", ct2);

        Address ad1 = new Address(null, "rua antônio", "450", "centro", "Tatuí", "SP", "18.999-999", ct2);
        Address ad2 = new Address(null, "rua antônio", "450", "centro", "Tatuí", "SP", "18.999-999", ct1);
        Address ad3 = new Address(null, "rua antônio", "450", "centro", "Tatuí", "SP", "18.999-999", ct2);

    
        categoryRepository.saveAll(Arrays.asList(c1, c2));
        bookRepository.saveAll(Arrays.asList(b1, b2));
        customerRepository.saveAll(Arrays.asList(ct1, ct2));
        phoneRepository.saveAll(Arrays.asList(ph1, ph2, ph3));
        addressRepository.saveAll(Arrays.asList(ad1,ad2, ad3));
             
    }
}

package com.ifsp.apiloja.config;

import java.time.Instant;
import java.util.Arrays;

import com.ifsp.apiloja.model.Address;
import com.ifsp.apiloja.model.Book;
import com.ifsp.apiloja.model.Category;
import com.ifsp.apiloja.model.Customer;
import com.ifsp.apiloja.model.Order;
import com.ifsp.apiloja.model.OrderItem;
import com.ifsp.apiloja.model.Phone;
import com.ifsp.apiloja.repository.AddressRepository;
import com.ifsp.apiloja.repository.BookRepository;
import com.ifsp.apiloja.repository.CategoryRepository;
import com.ifsp.apiloja.repository.CustomerRepository;
import com.ifsp.apiloja.repository.OrderItemRepository;
import com.ifsp.apiloja.repository.OrderRepository;
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

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {
        
        Category c1 = new Category(null, "Romance");
        Category c2 = new Category(null, "Suspense");

        categoryRepository.saveAll(Arrays.asList(c1, c2));

        Book b1 = new Book(null, "Kate Quinn", "A rede de Alice", "98754879", "Érica", "São Paulo", "2°", "2018", "480", 75.99, "legal", c1);
        Book b2 = new Book(null, "J. K. Rowling", "Harry Potter e a Criança Amaldiçoada", "98754879", "Rocco", "São Paulo", "1", "2016", "380", 35.99, "description", c2);

        bookRepository.saveAll(Arrays.asList(b1, b2));

        Customer ct1 = new Customer(null, "José Benfica", "999.888.777-66", "99.888.777-6", "testando@hotmail.com", "password", "ashduasjdas", "25/03/1997");

        Customer ct2 = new Customer(null, "Luciana da Silva", "111.222.333-44", "11.222.333-4", "teste@teste.com", "457895", "aksdhnsajdh", "13/02/1985");

        customerRepository.saveAll(Arrays.asList(ct1, ct2));

        Phone ph1 = new Phone(null, "11999998888", ct1);
        Phone ph2 = new Phone(null, "55999998888", ct1);
        Phone ph3 = new Phone(null, "38999998888", ct2);

        phoneRepository.saveAll(Arrays.asList(ph1, ph2, ph3));

        Address ad1 = new Address(null, "rua antônio", "450", "centro", "Tatuí", "SP", "18.111-999", ct2);
        Address ad2 = new Address(null, "Rua do Cruzeiro", "4450", "centro", "Itapetininga", "SP", "18.999-999", ct1);
        Address ad3 = new Address(null, "Comendador valadares", "589", "centro", "Ipero", "SP", "15.999-999", ct2);

        addressRepository.saveAll(Arrays.asList(ad1,ad2, ad3));

        Order od1 = new Order(null, Instant.parse("2021-01-20T19:53:07Z"), "cartão", "pago", ct1);
        Order od2 = new Order(null, Instant.parse("2021-01-20T19:53:07Z"), "boleto", "cancelado", ct1);

        orderRepository.saveAll(Arrays.asList(od1, od2));

        OrderItem oi1 = new OrderItem(null, 2, b1.getUnitaryValue(), b1, od1);
        OrderItem oi2 = new OrderItem(null, 4, b2.getUnitaryValue(), b2, od1);
        OrderItem oi3 = new OrderItem(null, 1, b2.getUnitaryValue(), b2, od2);
        OrderItem oi4 = new OrderItem(null, 3, b1.getUnitaryValue(), b1, od2);
        

        orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
             
    }
}

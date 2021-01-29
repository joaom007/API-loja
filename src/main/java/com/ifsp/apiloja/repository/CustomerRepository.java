package com.ifsp.apiloja.repository;

import com.ifsp.apiloja.model.Customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}

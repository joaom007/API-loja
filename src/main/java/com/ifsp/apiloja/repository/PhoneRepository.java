package com.ifsp.apiloja.repository;

import java.util.List;

import com.ifsp.apiloja.model.Phone;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PhoneRepository extends JpaRepository<Phone, Long>{

    @Query("select u from Phone u where u.customer.id = :id")
    List<Phone> selectPhoneByCustomer(Long id);

}

package com.ifsp.apiloja.repository;

import java.util.List;

import com.ifsp.apiloja.model.Address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AddressRepository extends JpaRepository<Address, Long>{

    @Query("select u from Address u where u.customer.id = :id")
    List<Address> selectAddressByCustomer(Long id);

}

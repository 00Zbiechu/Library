package com.example.demo.repository;

import com.example.demo.entity.Address;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository  extends JpaRepository<Address,Long> {


    @Query("SELECT a FROM Address a LEFT JOIN FETCH a.customer WHERE a.customer.firstName Not like 'Mateusz'")
    List<Address> findAllAddressAndCustomers(Pageable pageable);

}

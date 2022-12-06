package com.example.demo.repository;

import com.example.demo.entity.BookEntity;
import com.example.demo.entity.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentRepository extends JpaRepository<Rent,Long> {
}

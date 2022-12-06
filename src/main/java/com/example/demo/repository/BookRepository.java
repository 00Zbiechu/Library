package com.example.demo.repository;

import com.example.demo.entity.BookEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;



@Repository
public interface BookRepository extends JpaRepository<BookEntity,Long>{

}

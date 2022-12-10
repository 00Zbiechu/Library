package com.example.demo.repository;

import com.example.demo.entity.Author;
import com.example.demo.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {

    List<Author> findAuthorBySurname(String surname);

    @Query("SELECT a FROM Author a WHERE a.firstName like 'Adam'")
    List<Author> findAuthorsWithNameAdam();



}

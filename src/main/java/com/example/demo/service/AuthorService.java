package com.example.demo.service;

import com.example.demo.model.AddressDTO;
import com.example.demo.model.AuthorDTO;
import com.example.demo.repository.AuthorRepository;

import java.awt.print.Pageable;
import java.time.LocalDate;
import java.util.List;


public interface AuthorService {

    AuthorDTO getAuthorById(Long id);

    List<AuthorDTO> getAllAuthors();

    AuthorDTO addAuthor(AuthorDTO authorDTO);

    AuthorDTO updateAuthor(Long id, AuthorDTO authorDTO);

    void deleteAuthor(Long id);


    //Custom Query
    List<AuthorDTO> findAuthorBySurname(String surname);

    List<AuthorDTO> findAuthorWithNameAdam();

}

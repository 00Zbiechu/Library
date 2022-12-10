package com.example.demo.service;

import com.example.demo.entity.Author;
import com.example.demo.exception.AuthorNotFundException;
import com.example.demo.exception.BookNotFoundException;
import com.example.demo.model.AuthorDTO;
import com.example.demo.model.AuthorMapper;
import com.example.demo.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService{


    private final AuthorRepository authorRepository;
    
    @Override
    public AuthorDTO getAuthorById(Long id) {
        return authorRepository.findById(id)
                .map(AuthorMapper.INSTANCE::authorToDTO)
                .orElseThrow(AuthorNotFundException::new);
    }

    @Override
    public List<AuthorDTO> getAllAuthors() {
        return authorRepository.findAll()
                .stream()
                .map(AuthorMapper.INSTANCE::authorToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AuthorDTO addAuthor(AuthorDTO authorDTO) {
        Author author = authorRepository.save(AuthorMapper.INSTANCE.dtoToAuthor(authorDTO));
        return AuthorMapper.INSTANCE.authorToDTO(author);
    }

    @Override
    public AuthorDTO updateAuthor(Long id, AuthorDTO authorDTO) {
        authorDTO.setId(id);
        Author author = authorRepository.save(AuthorMapper.INSTANCE.dtoToAuthor(authorDTO));
        return AuthorMapper.INSTANCE.authorToDTO(author);
    }

    @Override
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }


    @Override
    public List<AuthorDTO> findAuthorBySurname(String surname){

        return authorRepository.findAuthorBySurname(surname).stream()
                .map(AuthorMapper.INSTANCE::authorToDTO).collect(Collectors.toList());

    }

    @Override
    public List<AuthorDTO> findAuthorWithNameAdam(){

        return authorRepository.findAuthorsWithNameAdam().stream()
                .map(AuthorMapper.INSTANCE::authorToDTO)
                .collect(Collectors.toList());

    }


}

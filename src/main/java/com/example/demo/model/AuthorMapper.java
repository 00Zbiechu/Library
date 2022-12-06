package com.example.demo.model;


import com.example.demo.entity.Author;
import com.example.demo.entity.BookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthorMapper {

    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    Author dtoToAuthor(AuthorDTO authorDTO);

    AuthorDTO authorToDTO(Author author);

}

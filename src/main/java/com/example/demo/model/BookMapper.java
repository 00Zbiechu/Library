package com.example.demo.model;

import com.example.demo.entity.BookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookEntity dtoToBook(BookDTO bookDTO);

    BookDTO bookToDTO(BookEntity bookEntity);

}

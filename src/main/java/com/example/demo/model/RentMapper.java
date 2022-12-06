package com.example.demo.model;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Rent;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RentMapper {

    RentMapper INSTANCE = Mappers.getMapper(RentMapper.class);

    Rent dtoToRent(RentDTO rentDTO);

    RentDTO rentToDTO(Rent rent);

}

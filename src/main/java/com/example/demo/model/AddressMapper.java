package com.example.demo.model;


import com.example.demo.entity.Address;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AddressMapper {

    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);



    Address dtoToAddress(AddressDTO addressDTO);

    AddressDTO addressToDTO(Address address);

}

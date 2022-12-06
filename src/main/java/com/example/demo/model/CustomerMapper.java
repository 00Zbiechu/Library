package com.example.demo.model;

import com.example.demo.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    Customer dtoToCustomer(CustomerDTO customerDTO);

    CustomerDTO customerToDTO(Customer customer);


}

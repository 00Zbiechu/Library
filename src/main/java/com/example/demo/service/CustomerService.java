package com.example.demo.service;

import com.example.demo.model.CustomerDTO;

import java.util.List;

public interface CustomerService {

    CustomerDTO getCustomerById(Long id);

    List<CustomerDTO> getAllCustomer();

    CustomerDTO addCustomer(CustomerDTO customerDTO);

    CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO);

    void deleteCustomer(Long id);

}

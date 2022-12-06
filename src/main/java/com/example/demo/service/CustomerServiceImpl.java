package com.example.demo.service;

import com.example.demo.entity.Customer;

import com.example.demo.exception.CustomerNotFoundException;
import com.example.demo.model.CustomerMapper;
import com.example.demo.model.CustomerMapper;
import com.example.demo.model.CustomerDTO;
import com.example.demo.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor

public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;


    @Override
    public CustomerDTO getCustomerById(Long id) {
        return customerRepository.findById(id)
                .map(CustomerMapper.INSTANCE::customerToDTO)
                .orElseThrow(CustomerNotFoundException::new);
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        return customerRepository.findAll()
                .stream()
                .map(CustomerMapper.INSTANCE::customerToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO addCustomer(CustomerDTO customerDTO) {
        Customer customer = customerRepository.save(CustomerMapper.INSTANCE.dtoToCustomer(customerDTO));
        return CustomerMapper.INSTANCE.customerToDTO(customer);
    }

    @Override
    public CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO) {
        customerDTO.setId(id);
        Customer customer = customerRepository.save(CustomerMapper.INSTANCE.dtoToCustomer(customerDTO));
        return CustomerMapper.INSTANCE.customerToDTO(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}

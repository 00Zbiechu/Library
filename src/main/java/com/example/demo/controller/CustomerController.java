package com.example.demo.controller;

import com.example.demo.model.CustomerDTO;
import com.example.demo.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customer")
public class CustomerController {
    
    private final CustomerService customerService;



    @GetMapping("/getcustomer")
    public List<CustomerDTO> fetchCustomer()
    {
        return customerService.getAllCustomer();
    }


    @GetMapping("/{id}")
    public CustomerDTO getCustomerById(@PathVariable("id") Long customerEntityId)
    {
        return customerService.getCustomerById(customerEntityId);
    }


    @PostMapping("/savecustomer")
    public CustomerDTO saveCustomer( @RequestBody CustomerDTO CustomerDTO)
    {
        return customerService.addCustomer(CustomerDTO);
    }



    @PutMapping("{id}")
    public CustomerDTO updateCustomer(@RequestBody CustomerDTO CustomerDTO, @PathVariable("id") Long customerEntityId)
    {
        return customerService.updateCustomer(customerEntityId, CustomerDTO);
    }


    @DeleteMapping("{id}")
    public String deleteCustomer(@PathVariable("id") Long customerEntityId)
    {
        customerService.deleteCustomer(customerEntityId);

        return "Deleted Successfully";
    }


    //Custome Querys
    @GetMapping("/name/{name}")
    public List<CustomerDTO> findAllCustomerWithName(@PathVariable("name") String name){

        return customerService.findAllCustomerWithName(name);

    }
    
}

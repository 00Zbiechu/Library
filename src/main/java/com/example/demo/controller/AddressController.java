package com.example.demo.controller;


import com.example.demo.model.AddressDTO;
import com.example.demo.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/address")
public class AddressController {


    private final AddressService addressService;



    @GetMapping("/getaddress")
    public List<AddressDTO> fetchAddress()
    {
        return addressService.getAllAddress();
    }


    @GetMapping("/{id}")
    public AddressDTO getAddressById(@PathVariable("id") Long addressEntityId)
    {
        return addressService.getAddressById(addressEntityId);
    }



    @PostMapping("/saveaddress")
    public AddressDTO saveAddress( @RequestBody AddressDTO addressDTO)
    {
        return addressService.addAddress(addressDTO);
    }



    @PutMapping("{id}")
    public AddressDTO updateAddress(@RequestBody AddressDTO addressDTO, @PathVariable("id") Long addressEntityId)
    {
        return addressService.updateAddress(addressEntityId, addressDTO);
    }


    @DeleteMapping("{id}")
    public String deleteBook(@PathVariable("id") Long addressEntityId)
    {
        addressService.deleteAddress(addressEntityId);

        return "Deleted Successfully";
    }


    @GetMapping("/addressandcustomers")
    public List<AddressDTO> findAllAddressAndCustomers(){

       return addressService.findAllAddressAndCustomers();

    }

}

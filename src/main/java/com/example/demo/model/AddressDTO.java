package com.example.demo.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class AddressDTO {

    private Long id;

    private String street;

    private String zipCode;

    private String houseNumber;

    private String city;

}

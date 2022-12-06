package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@Builder
@AllArgsConstructor
public class CustomerDTO {

    private Long id;
    private String firstName;
    private String surname;
    private String phoneNumber;
    private LocalDate birthDate;

}

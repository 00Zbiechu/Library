package com.example.demo.service;

import com.example.demo.model.CustomerDTO;
import com.example.demo.model.RentDTO;

import java.util.List;

public interface RentService {

    RentDTO getRentById(Long id);

    List<RentDTO> getAllRents();

    RentDTO addRent(RentDTO rentDTO);

    RentDTO updateRent(Long id, RentDTO rentDTO);

    void deleteRent(Long id);

}

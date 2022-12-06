package com.example.demo.service;

import com.example.demo.entity.Rent;
import com.example.demo.exception.RentNotFoundException;
import com.example.demo.model.RentMapper;
import com.example.demo.model.RentDTO;
import com.example.demo.repository.RentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RentServiceImpl implements RentService{

    private final RentRepository rentRepository;

    @Override
    public RentDTO getRentById(Long id) {
        return rentRepository.findById(id)
                .map(RentMapper.INSTANCE::rentToDTO)
                .orElseThrow(RentNotFoundException::new);
    }

    @Override
    public List<RentDTO> getAllRents() {
        return rentRepository.findAll()
                .stream()
                .map(RentMapper.INSTANCE::rentToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RentDTO addRent(RentDTO rentDTO) {
        Rent rent = rentRepository.save(RentMapper.INSTANCE.dtoToRent(rentDTO));
        return RentMapper.INSTANCE.rentToDTO(rent);
    }

    @Override
    public RentDTO updateRent(Long id, RentDTO rentDTO) {
        rentDTO.setId(id);
        Rent rent = rentRepository.save(RentMapper.INSTANCE.dtoToRent(rentDTO));
        return RentMapper.INSTANCE.rentToDTO(rent);
    }

    @Override
    public void deleteRent(Long id) {
        rentRepository.deleteById(id);
    }
}

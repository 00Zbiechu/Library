package com.example.demo.service;

import com.example.demo.entity.Address;
import com.example.demo.exception.AddressNotFoundException;
import com.example.demo.model.AddressDTO;
import com.example.demo.model.AddressMapper;
import com.example.demo.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService{

    private final AddressRepository addressRepository;

    @Override
    public AddressDTO getAddressById(Long id) {

        return addressRepository.findById(id)
                .map(AddressMapper.INSTANCE::addressToDTO)
                .orElseThrow(AddressNotFoundException::new);

    }

    @Override
    public List<AddressDTO> getAllAddress() {

        return addressRepository.findAll()
                .stream()
                .map(AddressMapper.INSTANCE::addressToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AddressDTO addAddress(AddressDTO addressDTO) {
        Address address = addressRepository.save(AddressMapper.INSTANCE.dtoToAddress(addressDTO));
        return AddressMapper.INSTANCE.addressToDTO(address);
    }

    @Override
    public AddressDTO updateAddress(Long id, AddressDTO addressDTO) {
        addressDTO.setId(id);
        Address address = addressRepository.save(AddressMapper.INSTANCE.dtoToAddress(addressDTO));
        return AddressMapper.INSTANCE.addressToDTO(address);
    }

    @Override
    public void deleteAddress(Long id) {

        addressRepository.deleteById(id);

    }


    @Override
    public List<AddressDTO> findAllAddressAndCustomers(){

        return addressRepository.findAllAddressAndCustomers(PageRequest.of(0,2)).stream()
                .map(AddressMapper.INSTANCE::addressToDTO)
                .collect(Collectors.toList());

    }
}

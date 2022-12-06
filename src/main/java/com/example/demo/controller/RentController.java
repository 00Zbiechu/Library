package com.example.demo.controller;

import com.example.demo.model.RentDTO;
import com.example.demo.service.RentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/rent")
public class RentController {
    
    private final RentService rentService;

    @GetMapping("/getrent")
    public List<RentDTO> fetchRents()
    {
        return rentService.getAllRents();
    }


    @GetMapping("/{id}")
    public RentDTO getRentById(@PathVariable("id") Long rentEntityId)
    {
        return rentService.getRentById(rentEntityId);
    }



    @PostMapping("/saverent")
    public RentDTO saveRent( @RequestBody RentDTO rentDTO)
    {
        return rentService.addRent(rentDTO);
    }



    @PutMapping("{id}")
    public RentDTO updateRent(@RequestBody RentDTO rentDTO, @PathVariable("id") Long rentEntityId)
    {
        return rentService.updateRent(rentEntityId, rentDTO);
    }


    @DeleteMapping("{id}")
    public String deleteRent(@PathVariable("id") Long rentEntityId)
    {
        rentService.deleteRent(rentEntityId);

        return "Deleted Successfully";
    }


}

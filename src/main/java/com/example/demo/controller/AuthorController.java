package com.example.demo.controller;


import com.example.demo.model.AddressDTO;
import com.example.demo.model.AuthorDTO;
import com.example.demo.service.AddressService;
import com.example.demo.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/author")
public class AuthorController {


    private final AuthorService authorService;



    @GetMapping("/getauthor")
    public List<AuthorDTO> fetchAddress()
    {
        return authorService.getAllAuthors();
    }


    @GetMapping("/{id}")
    public AuthorDTO getAuthorById(@PathVariable("id") Long authorEntityId)
    {
        return authorService.getAuthorById(authorEntityId);
    }



    @PostMapping("/saveauthor")
    public AuthorDTO saveAuthor( @RequestBody AuthorDTO authorDTO)
    {
        return authorService.addAuthor(authorDTO);
    }



    @PutMapping("{id}")
    public AuthorDTO updateAuthor(@RequestBody AuthorDTO authorDTO, @PathVariable("id") Long authorEntityId)
    {
        return authorService.updateAuthor(authorEntityId, authorDTO);
    }


    @DeleteMapping("{id}")
    public String deleteAuthor(@PathVariable("id") Long authorEntityId)
    {
        authorService.deleteAuthor(authorEntityId);

        return "Deleted Successfully";
    }

}

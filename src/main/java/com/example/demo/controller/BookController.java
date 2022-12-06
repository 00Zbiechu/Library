package com.example.demo.controller;

import com.example.demo.model.BookDTO;
import com.example.demo.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/book")
public class BookController {


    private final BookService bookService;



    @GetMapping("/getbook")
    public List<BookDTO> fetchBook()
    {
        return bookService.getAllBooks();
    }


    @GetMapping("/{id}")
    public BookDTO getBookById(@PathVariable("id") Long bookEntityId)
    {
        return bookService.getBookById(bookEntityId);
    }


    @PostMapping("/savebook")
    public BookDTO saveBook( @RequestBody BookDTO bookDTO)
    {
        return bookService.addBook(bookDTO);
    }



    @PutMapping("{id}")
    public BookDTO updateBook(@RequestBody BookDTO bookDTO, @PathVariable("id") Long bookEntityId)
    {
        return bookService.updateBook(bookEntityId, bookDTO);
    }


    @DeleteMapping("{id}")
    public String deleteBook(@PathVariable("id") Long bookEntityId)
    {
        bookService.deleteBook(bookEntityId);

        return "Deleted Successfully";
    }




}

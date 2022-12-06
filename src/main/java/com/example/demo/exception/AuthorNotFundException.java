package com.example.demo.exception;

public class AuthorNotFundException extends RuntimeException{

    public AuthorNotFundException() {
        super("Author not found");
    }

}

package com.example.demo.exception;

public class RentNotFoundException extends RuntimeException{

    public RentNotFoundException() {
        super("Rent not found");
    }

}

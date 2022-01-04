package com.blooddonar.blooddonation.DonorException;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }
}

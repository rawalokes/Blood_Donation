package com.blooddonar.blooddonation.DonorException;

public class EmptyDataException extends RuntimeException{
    public EmptyDataException(String message) {
        super(message);
    }
}

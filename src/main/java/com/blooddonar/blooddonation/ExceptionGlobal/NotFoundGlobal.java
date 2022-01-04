package com.blooddonar.blooddonation.ExceptionGlobal;

import com.blooddonar.blooddonation.DonorException.EmptyDataException;
import com.blooddonar.blooddonation.DonorException.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class NotFoundGlobal extends ResponseEntityExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handelNotFoundException(NotFoundException notFoundException){
        return new ResponseEntity<>(notFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmptyDataException.class)
    public ResponseEntity<String> handleEmptyDataException(EmptyDataException emptyDataException){
        return new ResponseEntity<>(emptyDataException.getMessage(),HttpStatus.BAD_REQUEST);
    }
}

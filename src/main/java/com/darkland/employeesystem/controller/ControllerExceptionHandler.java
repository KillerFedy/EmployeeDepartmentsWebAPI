package com.darkland.employeesystem.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<?> NoSuchElementHandle(NoSuchElementException exception)
    {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

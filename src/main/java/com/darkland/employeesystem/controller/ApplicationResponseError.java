package com.darkland.employeesystem.controller;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ApplicationResponseError {
    private HttpStatus status;
    private String errorMessage;

    public ApplicationResponseError(HttpStatus status, String errorMessage) {
        this.status = status;
        this.errorMessage = errorMessage;
    }
}

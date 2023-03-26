package com.example.sportsteamdatamanagementappp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NoDataAviableException extends RuntimeException {
    public NoDataAviableException(String message) {
        super(message);
    }
}
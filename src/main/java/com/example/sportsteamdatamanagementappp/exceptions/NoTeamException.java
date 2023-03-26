package com.example.sportsteamdatamanagementappp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NoTeamException extends RuntimeException {
    public NoTeamException(String message) {
        super(message);
    }
}
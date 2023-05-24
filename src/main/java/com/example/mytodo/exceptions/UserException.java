package com.example.mytodo.exceptions;

import org.springframework.http.HttpStatus;

public class UserException extends Exception {
    public UserException(String message, HttpStatus status) {
        super(message);
    }
}

package com.springmvc.springmvcexcercise.exceptions;

import org.springframework.http.HttpStatus;

public class ValidationException extends CustomException {

    public ValidationException(String message) {
        super(HttpStatus.valueOf(422), message);
    }
}

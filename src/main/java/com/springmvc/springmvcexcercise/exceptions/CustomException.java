package com.springmvc.springmvcexcercise.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CustomException extends RuntimeException {

    private final HttpStatus httpStatus;
    private final String lastName;
    private final String message;

    public CustomException(HttpStatus httpStatus, String lastName, String message){
        super(message);
        this.httpStatus = httpStatus;
        this.lastName = lastName;
        this.message = message;
    }
}

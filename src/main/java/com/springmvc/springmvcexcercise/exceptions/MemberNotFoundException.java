package com.springmvc.springmvcexcercise.exceptions;

import org.springframework.http.HttpStatus;

public class MemberNotFoundException extends CustomException{

    public MemberNotFoundException(String message, String lastName){
        super(HttpStatus.NOT_FOUND, lastName, message);
    }
}

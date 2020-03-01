package com.springmvc.springmvcexcercise.exceptions;

import org.springframework.http.HttpStatus;

public class MemberNotFoundException extends CustomException {

    public MemberNotFoundException(String message, Integer id) {
        super(HttpStatus.NOT_FOUND, message);
    }
}

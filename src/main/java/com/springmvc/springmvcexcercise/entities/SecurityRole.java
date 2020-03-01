package com.springmvc.springmvcexcercise.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum SecurityRole {

    ADMIN("admin"),
    USER("user");

    private final String name;
}

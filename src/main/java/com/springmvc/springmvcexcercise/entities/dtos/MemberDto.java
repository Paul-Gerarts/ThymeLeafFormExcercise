package com.springmvc.springmvcexcercise.entities.dtos;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@Builder
@RequiredArgsConstructor
public class MemberDto {

    private final String userName;
    private final String password;
    private final String securityRole;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String street;
    private final String number;
    private final String postBox;
    private final String postalCode;
    private final String city;
    private final String phoneNumber;
    private final String birthday;
    private final String role;
    private final List<String> knittingStiches;
}

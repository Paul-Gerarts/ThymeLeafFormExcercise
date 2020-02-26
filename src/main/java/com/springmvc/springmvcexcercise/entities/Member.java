package com.springmvc.springmvcexcercise.entities;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Data
@ToString
@Builder
public class Member {

    private final String userName;
    private final String password;
    private final SecurityRole securityRole;

    private final String firstName;
    private final String lastName;
    private final String email;
    private final Address address;
    private final String phoneNumber;
    private final LocalDate birthday;
    private final MemberShipRole role;
    private final List<KnittingStich> knittingStiches;
}

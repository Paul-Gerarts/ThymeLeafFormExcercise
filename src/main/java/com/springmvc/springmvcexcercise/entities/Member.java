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

    private String userName;
    private String password;
    private SecurityRole securityRole;

    private String firstName;
    private String lastName;
    private String email;
    private Address address;
    private String phoneNumber;
    private LocalDate birthday;
    private MemberShipRole role;
    private List<KnittingStich> knittingStiches;
}

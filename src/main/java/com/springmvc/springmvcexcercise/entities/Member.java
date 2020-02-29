package com.springmvc.springmvcexcercise.entities;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.lang.NonNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Data
@ToString
@Builder
public class Member {

    @NotBlank
    private final String userName;
    @NotBlank
    private final String password;
    @NonNull
    private final SecurityRole securityRole;
    @NotBlank
    private final String firstName;
    @NotBlank
    private final String lastName;
    @NotBlank
    private final String email;
    @NonNull
    private final Address address;
    @NotBlank
    private final String phoneNumber;
    @Past
    private final LocalDate birthday;
    @NotBlank
    private final String role;
    @Size(min = 1)
    private final List<String> knittingStiches;

}

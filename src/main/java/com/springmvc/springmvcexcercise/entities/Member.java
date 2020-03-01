package com.springmvc.springmvcexcercise.entities;

import com.springmvc.springmvcexcercise.validation.PhoneNumber;
import lombok.*;
import org.springframework.lang.NonNull;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
@Builder
@RequiredArgsConstructor
public class Member {

    private final Integer id;
    @NotBlank
    private final String userName;
    @NotBlank
    private final String password;
    @Pattern(regexp = "user|admin")
    private final SecurityRole securityRole;
    @NotBlank
    private final String firstName;
    @NotBlank
    private final String lastName;
    @NotBlank
    @Email
    private final String email;
    @NonNull
    private final Address address;
    @NotBlank
    @PhoneNumber
    private final String phoneNumber;
    @Past
    private final LocalDate birthday;
    @NotBlank
    private final String role;
    @Size(min = 1)
    private final List<String> knittingStiches;

}

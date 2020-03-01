package com.springmvc.springmvcexcercise.entities.dtos;

import com.springmvc.springmvcexcercise.validation.PhoneNumber;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@ToString
@Builder
@RequiredArgsConstructor
public class MemberDto {

    private final Integer id;
    @Pattern(regexp = "user|admin")
    private final String securityRole;
    @NotBlank
    private final String firstName;
    @NotBlank
    private final String lastName;
    @NotBlank
    @Email
    private final String email;
    @NotBlank
    private final String street;
    @NotBlank
    private final String number;
    @NotBlank
    private final String postBox;
    @NotBlank
    private final String postalCode;
    @NotBlank
    private final String city;
    @NotBlank
    @PhoneNumber
    private final String phoneNumber;
    @NotBlank
    private final String birthday;
    @NotBlank
    private final String role;
    @Size(min = 1)
    private final List<String> knittingStiches;
}

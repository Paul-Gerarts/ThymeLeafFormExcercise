package com.springmvc.springmvcexcercise.entities;

import lombok.Builder;
import lombok.Data;
import org.springframework.lang.NonNull;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class Address {

    @NotBlank
    private String street;
    @NotBlank
    private String number;
    @NonNull
    private String postBox;
    @NotBlank
    private String postalCode;
    @NotBlank
    private String city;

    @Override
    public String toString() {
        return "straat: " + street +
                ", nummer: " + number +
                ", postbus: " + postBox +
                ", postcode: " + postalCode +
                ", stad: " + city;
    }
}

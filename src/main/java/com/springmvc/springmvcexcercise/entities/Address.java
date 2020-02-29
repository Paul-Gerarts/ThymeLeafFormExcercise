package com.springmvc.springmvcexcercise.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {

    private String street;
    private Integer number;
    private Integer postBox;
    private Integer postalCode;
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

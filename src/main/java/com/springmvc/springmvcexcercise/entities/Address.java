package com.springmvc.springmvcexcercise.entities;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class Address {

    private String street;
    private Integer number;
    private Integer postBox;
    private Integer postalCode;
    private String city;

}

package com.springmvc.springmvcexcercise.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum MemberShipRole {

    PRESIDENT("President"),
    VICE_PRESIDENT("Vice president"),
    SECRETARY("Secretary"),
    TREASURER("Treasurer"),
    MEMBER("Member");

    private final String name;

}

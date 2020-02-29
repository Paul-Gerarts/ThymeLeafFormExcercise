package com.springmvc.springmvcexcercise.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum MemberShipRole {

    PRESIDENT("President"),
    VICE_PRESIDENT("Vice president"),
    SECRETARY("secretary"),
    TREASURER("treasurer"),
    MEMBER("member");

    private final String name;

}

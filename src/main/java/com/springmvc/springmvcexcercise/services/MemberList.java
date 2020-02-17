package com.springmvc.springmvcexcercise.services;

import com.springmvc.springmvcexcercise.entities.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberList implements Serializable {

    private List<Member> members;
}

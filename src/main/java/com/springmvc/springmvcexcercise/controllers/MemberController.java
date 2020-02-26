package com.springmvc.springmvcexcercise.controllers;

import com.springmvc.springmvcexcercise.entities.Member;
import com.springmvc.springmvcexcercise.impl.MemberRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberRepositoryImpl memberService;

    @Autowired
    public MemberController(MemberRepositoryImpl memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public ResponseEntity<List<Member>> getMembers() {
        return ResponseEntity.ok(memberService.getAllMembers());
    }

    @GetMapping("{lastName}")
    public Member getMember(@PathVariable("lastName") String lastName) {
        return memberService.getMember(lastName);
    }
}

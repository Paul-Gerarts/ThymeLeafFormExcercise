package com.springmvc.springmvcexcercise.controllers;

import com.springmvc.springmvcexcercise.impl.MemberServiceImpl;
import com.springmvc.springmvcexcercise.services.MemberList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/homepage")
public class AdminController {

    private MemberServiceImpl memberRepository;

    @Autowired
    public AdminController(MemberServiceImpl memberRepository) {
        this.memberRepository = memberRepository;
    }

    @GetMapping
    public MemberList getMembers(){
        return new MemberList(memberRepository.getAllMembers());
    }
}

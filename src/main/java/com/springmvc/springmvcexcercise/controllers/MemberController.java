package com.springmvc.springmvcexcercise.controllers;

import com.springmvc.springmvcexcercise.entities.Member;
import com.springmvc.springmvcexcercise.services.MemberList;
import com.springmvc.springmvcexcercise.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/members")
public class MemberController {

    private MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @GetMapping
    public ModelAndView getMembers(){
        return new ModelAndView("members", "members" ,memberService.getAllMembers());
    }

    @GetMapping("{lastName}")
    public Member getMember(@PathVariable("lastName") String lastName){
        return memberService.getMember(lastName);
    }
}

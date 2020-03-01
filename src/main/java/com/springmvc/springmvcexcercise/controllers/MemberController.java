package com.springmvc.springmvcexcercise.controllers;

import com.springmvc.springmvcexcercise.entities.Member;
import com.springmvc.springmvcexcercise.impl.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/members")
public class MemberController {

    public static final String MEMBERS = "members";
    private MemberServiceImpl memberRepository;

    @Autowired
    public MemberController(MemberServiceImpl memberRepository) {
        this.memberRepository = memberRepository;
    }

    @GetMapping
    public ModelAndView handleGet() {
        return new ModelAndView(MEMBERS, MEMBERS, memberRepository.getAllMembers());
    }

    @GetMapping("/detail/{id}")
    public ModelAndView handleGet(@PathVariable("id") Integer id) {
        Member member = memberRepository.getMember(id);
        return null != member
                ? new ModelAndView("membersDetail", "member", member)
                : new ModelAndView(MEMBERS);
    }

}

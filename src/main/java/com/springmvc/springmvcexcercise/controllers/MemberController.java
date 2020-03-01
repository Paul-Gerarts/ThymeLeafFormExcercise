package com.springmvc.springmvcexcercise.controllers;

import com.springmvc.springmvcexcercise.entities.KnittingStiches;
import com.springmvc.springmvcexcercise.entities.Member;
import com.springmvc.springmvcexcercise.entities.MemberShipRole;
import com.springmvc.springmvcexcercise.entities.SecurityRole;
import com.springmvc.springmvcexcercise.entities.dtos.MemberDto;
import com.springmvc.springmvcexcercise.impl.MemberServiceImpl;
import com.springmvc.springmvcexcercise.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/members")
public class MemberController {

    public static final String MEMBERS = "members";
    private MemberServiceImpl memberRepository;
    private MemberService memberService;

    @Autowired
    public MemberController(MemberServiceImpl memberRepository, MemberService memberService) {
        this.memberRepository = memberRepository;
        this.memberService = memberService;
    }

    @ModelAttribute("roleList")
    public List<String> getRoles() {
        return Arrays.stream(SecurityRole.values())
                .map(SecurityRole::getName)
                .collect(Collectors.toUnmodifiableList());
    }

    @ModelAttribute("memberRoleList")
    public List<String> getMemberRoles() {
        return Arrays.stream(MemberShipRole.values())
                .map(MemberShipRole::getName)
                .collect(Collectors.toUnmodifiableList());
    }

    @ModelAttribute("knittingStiches")
    public List<String> getKnittingStiches() {
        return Arrays.stream(KnittingStiches.values())
                .map(KnittingStiches::getName)
                .collect(Collectors.toUnmodifiableList());
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

    @GetMapping("/detail/{id}/edit")
    public String forward(@PathVariable("id") Integer id, Model model) {
        Member member = memberRepository.getMember(id);
        model.addAttribute("myform", memberService.mapToDto(member));
        return "/inputForm";
    }

    @PostMapping("/detail/{id}/edit")
    public String handleForm(@Valid @ModelAttribute("myform") MemberDto form, BindingResult bindingResult) {
        return memberService.addMemberImpl(form, bindingResult);
    }

    @GetMapping("/create")
    public String forward(Model model) {
        model.addAttribute("myform", MemberDto.builder()
                .securityRole("user")
                .postBox("")
                .build());
        return "/inputForm";
    }

    @PostMapping("/create")
    public String addMember(@Valid @ModelAttribute("myform") MemberDto form, BindingResult bindingResult) {
        return memberService.addMemberImpl(form, bindingResult);
    }

}

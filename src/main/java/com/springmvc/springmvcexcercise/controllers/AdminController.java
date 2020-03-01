package com.springmvc.springmvcexcercise.controllers;

import com.springmvc.springmvcexcercise.entities.KnittingStiches;
import com.springmvc.springmvcexcercise.entities.MemberShipRole;
import com.springmvc.springmvcexcercise.entities.SecurityRole;
import com.springmvc.springmvcexcercise.entities.dtos.MemberDto;
import com.springmvc.springmvcexcercise.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private MemberService memberService;

    @ModelAttribute("roleList")
    public List<String> getRoles() {
        return Arrays.stream(SecurityRole.values())
                .map(Enum::toString)
                .map(String::toLowerCase)
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
    public String forward(@ModelAttribute("myform") MemberDto form) {
        return "/inputForm";
    }

    @PostMapping
    public String handleForm(@Valid @ModelAttribute("myform") MemberDto form, BindingResult bindingResult) {
        memberService.addMember(form);
        if (bindingResult.hasErrors()) {
            for (String code : Objects.requireNonNull(Objects.requireNonNull(bindingResult.getFieldError()).getCodes())) {
                System.out.println(code);
            }
            System.out.println("error");
            return "/inputForm";
        }
        return "/members";
    }
}

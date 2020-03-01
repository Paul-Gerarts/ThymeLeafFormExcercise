package com.springmvc.springmvcexcercise.services;

import com.springmvc.springmvcexcercise.entities.Address;
import com.springmvc.springmvcexcercise.entities.Member;
import com.springmvc.springmvcexcercise.entities.SecurityRole;
import com.springmvc.springmvcexcercise.entities.dtos.MemberDto;
import com.springmvc.springmvcexcercise.impl.MemberRepositoryImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Data
@Service
@AllArgsConstructor
@Slf4j
public class MemberService {

    private MemberRepositoryImpl memberRepository;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Autowired
    public MemberService() {
        this.memberRepository = new MemberRepositoryImpl();
    }

    public void addMember(MemberDto dto) {
        memberRepository.addMember(
                Member.builder()
                        .id(null == dto.getId() ? this.memberRepository.getNextIndex() : dto.getId())
                        .userName(dto.getFirstName())
                        .password(dto.getLastName())
                        .securityRole(getRoleByName(dto.getSecurityRole()))
                        .firstName(dto.getFirstName())
                        .lastName(dto.getLastName())
                        .address(Address.builder()
                                .street(dto.getStreet())
                                .number(dto.getNumber())
                                .postBox(dto.getPostBox())
                                .postalCode(dto.getPostalCode())
                                .city(dto.getCity())
                                .build())
                        .birthday(LocalDate.parse(dto.getBirthday(), formatter))
                        .knittingStiches(dto.getKnittingStiches())
                        .role(dto.getRole())
                        .phoneNumber(dto.getPhoneNumber())
                        .email(dto.getEmail())
                        .build());
    }

    public MemberDto mapToDto(Member member) {
        return MemberDto.builder()
                .id(member.getId())
                .securityRole(member.getSecurityRole().getName())
                .firstName(member.getFirstName())
                .lastName(member.getLastName())
                .street(member.getAddress().getStreet())
                .number(member.getAddress().getNumber())
                .postBox(member.getAddress().getPostBox())
                .postalCode(member.getAddress().getPostalCode())
                .city(member.getAddress().getCity())
                .birthday(member.getBirthday().toString())
                .knittingStiches(member.getKnittingStiches())
                .role(member.getRole())
                .phoneNumber(member.getPhoneNumber())
                .email(member.getEmail())
                .build();
    }

    public SecurityRole getRoleByName(String roleName) {
        switch (roleName) {
            case "admin":
                return SecurityRole.ADMIN;
            default:
            case "user":
                return SecurityRole.USER;
        }
    }

    public String addMemberImpl(@ModelAttribute("myform") @Valid MemberDto form, BindingResult bindingResult) {
        addMember(form);
        if (bindingResult.hasErrors()) {
            for (String code : Objects.requireNonNull(Objects.requireNonNull(bindingResult.getFieldError()).getCodes())) {
                log.error(code);
            }
            return "/inputForm";
        }
        return "redirect:/members";
    }
}

package com.springmvc.springmvcexcercise.services;

import com.springmvc.springmvcexcercise.entities.Address;
import com.springmvc.springmvcexcercise.entities.Member;
import com.springmvc.springmvcexcercise.entities.dtos.MemberDto;
import com.springmvc.springmvcexcercise.impl.MemberRepositoryImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@Service
@AllArgsConstructor
public class MemberService {

    private MemberRepositoryImpl memberRepository;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Autowired
    private Validation validate;

    @Autowired
    public MemberService() {
        this.memberRepository = new MemberRepositoryImpl();
    }

    public void addMember(MemberDto dto) {
        memberRepository.addMember(
                Member.builder()
                        .userName(dto.getFirstName())
                        .password(dto.getLastName())
                        .securityRole(validate.getRoleByName(dto.getSecurityRole()))
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
                        .phoneNumber(validate.validatePhoneNumber(dto.getPhoneNumber()))
                        .email(validate.validateEmail(dto.getEmail()))
                        .build());
    }
}

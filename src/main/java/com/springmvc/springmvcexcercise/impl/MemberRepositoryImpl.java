package com.springmvc.springmvcexcercise.impl;

import com.springmvc.springmvcexcercise.entities.Address;
import com.springmvc.springmvcexcercise.entities.Member;
import com.springmvc.springmvcexcercise.entities.MemberShipRole;
import com.springmvc.springmvcexcercise.entities.SecurityRole;
import com.springmvc.springmvcexcercise.repositories.MemberRepository;
import com.springmvc.springmvcexcercise.validation.Validation;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.springmvc.springmvcexcercise.entities.KnittingStiches.*;

@Data
@AllArgsConstructor
public class MemberRepositoryImpl implements MemberRepository {

    private int index;
    private Map<Integer, Member> members;
    private Validation validate = new Validation();

    public MemberRepositoryImpl() {
        members = new HashMap<>();

        members.put(index,
                Member.builder()
                        .id(getNextIndex())
                        .userName("admin")
                        .password("admin")
                        .securityRole(SecurityRole.ADMIN)
                        .firstName("Jef")
                        .lastName("Swennen")
                        .address(Address.builder()
                                .street("Kanaalstraat")
                                .number("61")
                                .postBox("3")
                                .postalCode("3680")
                                .city("Neeroeteren")
                                .build())
                        .birthday(LocalDate.of(1987, 6, 24))
                        .knittingStiches(List.of(
                                CABLE.getName(),
                                STOCKINETTE.getName()
                        ))
                        .role(MemberShipRole.PRESIDENT.getName())
                        .phoneNumber("089/86.18.70")
                        .email("Jef.email@gmail.com")
                        .build());

        members.put(index,
                Member.builder()
                        .id(getNextIndex())
                        .userName("Maria")
                        .password("Stefens")
                        .securityRole(SecurityRole.USER)
                        .firstName("Maria")
                        .lastName("Stefens")
                        .address(Address.builder()
                                .street("Gruitroderstraat")
                                .number("45")
                                .postBox("")
                                .postalCode("3960")
                                .city("Bree")
                                .build())
                        .birthday(LocalDate.of(1983, 9, 15))
                        .knittingStiches(List.of(
                                RIB.getName(),
                                SEED.getName(),
                                BEGINNER_LACE.getName(),
                                GARTER.getName()
                        ))
                        .role(MemberShipRole.VICE_PRESIDENT.getName())
                        .phoneNumber("0494/23.20.55")
                        .email("Marleen_email@telenet.be")
                        .build());
    }

    @Override
    public List<Member> getAllMembers() {
        return new ArrayList<>(members.values());
    }

    @Override
    public Member getMember(Integer id) {
        return members.values().stream()
                .filter(member -> id.equals(member.getId()))
                .findFirst()
                .orElse(null);
    }

    public void addMember(Member newMember) {
        members.put(newMember.getId(), newMember);
    }

    public Integer getNextIndex() {
        return index++;
    }
}

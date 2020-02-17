package com.springmvc.springmvcexcercise.impl;

import com.springmvc.springmvcexcercise.entities.Address;
import com.springmvc.springmvcexcercise.entities.Member;
import com.springmvc.springmvcexcercise.entities.MemberShipRole;
import com.springmvc.springmvcexcercise.entities.SecurityRole;
import com.springmvc.springmvcexcercise.repositories.MemberRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.springmvc.springmvcexcercise.entities.KnittingStich.*;

@Service
public class MemberRepositoryImpl implements MemberRepository {

    private Map<Integer, Member> members;

    @PostConstruct
    private void init() {
        members = new HashMap<>();

        members.put(1,
                Member.builder()
                        .userName("admin")
                        .password("admin")
                        .securityRole(SecurityRole.ADMIN)
                        .firstName("Jef")
                        .lastName("Swennen")
                        .address(Address.builder()
                                .street("Kanaalstraat")
                                .number(61)
                                .postBox(null)
                                .postalCode(3680)
                                .city("Neeroeteren")
                                .build())
                        .birthday(LocalDate.of(1987, 6, 24))
                        .knittingStiches(List.of(
                                CABLE,
                                STOCKINETTE
                        ))
                        .role(MemberShipRole.PRESIDENT)
                        .phoneNumber("089/86.18.71")
                        .email("Jef.Swennen@gmail.com")
                        .build());

        members.put(2,
                Member.builder()
                        .userName("Maria")
                        .password("Stefens")
                        .securityRole(SecurityRole.USER)
                        .firstName("Maria")
                        .lastName("Stefens")
                        .address(Address.builder()
                                .street("Gruitroderstraat")
                                .number(45)
                                .postBox(null)
                                .postalCode(3960)
                                .city("Bree")
                                .build())
                        .birthday(LocalDate.of(1983, 9, 15))
                        .knittingStiches(List.of(
                                RIB,
                                SEED,
                                BEGINNER_LACE,
                                GARTER
                        ))
                        .role(MemberShipRole.VICE_PRESIDENT)
                        .phoneNumber("0494/23.20.53")
                        .email("Marleen_Stefens@telenet.be")
                        .build());
    }

    @Override
    public List<Member> getAllMembers() {
        return new ArrayList<>(members.values());
    }

    @Override
    public Member getMember(String lastName) {
        List<Member> matches = members.values().stream()
                .map(Member::getLastName)
                .filter(name -> name.equals(lastName))
                .distinct()
                .map(this::getMember)
                .collect(Collectors.toUnmodifiableList());
        return matches.isEmpty() ? null : matches.get(0);
    }
}

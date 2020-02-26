package com.springmvc.springmvcexcercise.impl;

import com.springmvc.springmvcexcercise.entities.Member;
import com.springmvc.springmvcexcercise.exceptions.MemberNotFoundException;
import com.springmvc.springmvcexcercise.repositories.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Data
public class MemberServiceImpl implements MemberRepository {

    @Autowired
    private MemberRepositoryImpl memberRepository;

    @Autowired
    public MemberServiceImpl() {
        this.memberRepository = new MemberRepositoryImpl();
    }

    @Override
    public List<Member> getAllMembers(){
        return memberRepository.getAllMembers();
    }

    @Override
    public Member getMember(String lastName){
        Member member = memberRepository.getMember(lastName);
        if (null != member) {
            return member;
        } else {
            throw new MemberNotFoundException("A member with the last name of '" + lastName + "' has not been found", lastName);
        }
    }
}

package com.springmvc.springmvcexcercise.impl;

import com.springmvc.springmvcexcercise.entities.Member;
import com.springmvc.springmvcexcercise.exceptions.MemberNotFoundException;
import com.springmvc.springmvcexcercise.repositories.MemberRepository;
import com.springmvc.springmvcexcercise.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
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
            throw new MemberNotFoundException("A member with the last name of " + lastName + " has not been found", lastName);
        }
    }
}

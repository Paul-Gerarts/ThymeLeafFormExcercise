package com.springmvc.springmvcexcercise.repositories;

import com.springmvc.springmvcexcercise.entities.Member;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository {

    List<Member> getAllMembers();

    Member getMember(String lastName);
}

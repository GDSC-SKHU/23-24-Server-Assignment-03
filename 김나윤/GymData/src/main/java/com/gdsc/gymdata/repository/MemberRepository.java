package com.gdsc.gymdata.repository;

import com.gdsc.gymdata.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository {

    void save(Member member);
    Member findById(Long id);
    List<Member> findAll();
    void updateById(Long id, Member member);
    void deleteById(Long id);
}

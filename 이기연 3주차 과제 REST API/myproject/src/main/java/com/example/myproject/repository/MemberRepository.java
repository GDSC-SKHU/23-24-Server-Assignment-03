package com.example.myproject.repository;

import com.example.myproject.domain.Member;

import java.util.List;

public interface MemberRepository {

    // 회원 정보를 저장하는 메소드
    void save(Member member);

    // 특정 ID에 해당하는 회원 정보를 조회하는 메소드
    Member findById(Long id);

    // 모든 회원 정보를 조회하는 메소드
    List<Member> findAll();

    // 특정 ID에 해당하는 회원 정보를 업데이트하는 메소드
    void updateById(Long id, Member member);

    // 특정 ID에 해당하는 회원 정보를 삭제하는 메소드
    void deleteById(Long id);

}

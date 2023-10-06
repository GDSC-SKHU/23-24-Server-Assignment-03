package com.gdsc.pcbangmembershipmanagement.repository;

import com.gdsc.pcbangmembershipmanagement.domain.Member;

import java.util.List;


public interface MemberRepository {
    void createAccount(Member member);  // 계정 생성 메소드
    Member findById(String id);  // 회원 한명의 id 조회 메소드
    List<Member> findAllId();  //  회원 id 전체 조회 메소드
    void updateById(String id, Member member);  // 회원 정보 수정 메소드
    void deleteById(String id);  // 아이디 삭제 메소드


}

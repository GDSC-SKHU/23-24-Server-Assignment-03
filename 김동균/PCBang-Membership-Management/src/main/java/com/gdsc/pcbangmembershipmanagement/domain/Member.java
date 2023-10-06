package com.gdsc.pcbangmembershipmanagement.domain;

import lombok.Builder;
import lombok.Getter;


@Getter
public class Member {
    private String id;  // 회원 아이디
    private String pw;  // 화원 비밀번호
    private String name;  // 회원 이름
    private Integer birthYear; // 회원 생년

    @Builder
    public Member(String id, String pw, String name, Integer birthYear) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.birthYear = birthYear;
    }
    public void initId(String id){
        this.id = id;
    }  // 아이디 수정 메소드
    public void initPw(String pw) {
        this.pw = pw;
    }  // 비밀번호 수정 메소드(사용x)
    public void updateName(String name) {  // 이름 수정 메소드 (사용 x)
        this.name = name;
    }  // 이름 수정 메소드(사용 x)
    public void updateBirthYear(Integer birthYear){
        this.birthYear = birthYear;
    }  // 생년 수정 메소드 (사용 x)
}

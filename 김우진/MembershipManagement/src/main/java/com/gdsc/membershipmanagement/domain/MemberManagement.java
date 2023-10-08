package com.gdsc.membershipmanagement.domain;
import jdk.jshell.Snippet;
import lombok.Getter;
import lombok.Builder;

@Getter
public class MemberManagement {
    private Long id; // 고유 아이디
    private String userid; // 사용자 Id
    private String userpassword; // 사용자 password

    @Builder
    public MemberManagement(Long id, String userid, String userpassword) {
        this.id = id;
        this.userid = userid;
        this.userpassword = userpassword;
    }

    public void initId(Long id) {
        this.id = id;
    }// id에 직접 손대는것은 위험하다..! ㅠㅠ

}

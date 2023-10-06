package com.gdsc.pcbangmembershipmanagement.dto;

import com.gdsc.pcbangmembershipmanagement.domain.Member;
import lombok.Builder;
import lombok.Data;

@Data
public class MemberDto {
        private String id;  // 회원 아이디
        private String pw;  // 화원 비밀번호
        private String name;  // 회원 이름
        private Integer birthYear;  // 회원 생년

        @Builder
        public MemberDto(String id, String pw, String name, Integer birthYear) {
                this.id = id;
                this.pw = pw;
                this.name = name;
                this.birthYear = birthYear;
        }

        //MemberDto -> Member
        public Member toEntity() {
                return Member.builder()
                        .id(id)
                        .pw(pw)
                        .name(name)
                        .birthYear(birthYear)
                        .build();
        }

}

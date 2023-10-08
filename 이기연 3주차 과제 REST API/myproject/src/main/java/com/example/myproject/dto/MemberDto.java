package com.example.myproject.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class MemberDto {

    // 회원의 고유 식별자
    private Long id;

    // 회원의 이름
    private String name;

    // 회원의 전화번호
    private Long phone_number;

    // 빌더 패턴을 이용한 생성자
    @Builder
    public MemberDto(Long id, String name, Long phone_number) {
        this.id = id;
        this.name = name;
        this.phone_number = phone_number;
    }

}

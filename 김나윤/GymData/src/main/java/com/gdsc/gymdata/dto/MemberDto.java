package com.gdsc.gymdata.dto;

import lombok.Builder;
import lombok.Data;

// DTO 사용시 도메인 모델 캡슐화하여 보호 가능
@Data
public class MemberDto {

    private Long id;
    private String name;
    private Long height;
    private Long weight;

    @Builder
    public MemberDto(Long id, String name, Long height, Long weight) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.weight = weight;
    }
}

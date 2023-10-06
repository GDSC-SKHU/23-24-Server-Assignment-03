package com.gdsc.gymdata.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Member {

    private Long id;
    private String name;
    private Long height;
    private Long weight;

    /* @Builder
    -Setter 사용할 때 보다 객체 일관성 유지, 변경 목적 파악 용이함
    -생성시 값을 지정하지 않으면 타입에 따라 0, null, false 값이 할당됨
    -@Builder.Default 어노테이션으로 기본값 지정하여 초기화 가능
     */
    @Builder
    public Member(String name, Long height, Long weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    // id 수정 위한 메소드 설정
    // 실제 프로젝트에서 id 필드 접근은 매우 위험
    public void initId(Long id) {
        this.id = id;
    }

    // Member 객체 수정 위한 메소드 설정
    public void updateMember(String name, Long height, Long weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }
}

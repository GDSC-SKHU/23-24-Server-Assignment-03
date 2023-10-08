package com.example.myproject.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Member {

    // 회원의 고유 식별자
    private Long id;

    // 회원의 이름
    private String name;

    // 회원의 전화번호
    private Long phone_number;

    // 빌더 패턴을 이용한 생성자
    @Builder
    public Member(String name, Long phone_number) {
        this.name = name;
        this.phone_number = phone_number;
    }

    // id 필드를 초기화하는 메소드
    // ** 실제 프로젝트에서는 id 필드를 외부에서 직접 초기화하는 것은 위험할 수 있습니다. **
    // 단, 전체 흐름 파악을 위해 사용했습니다.
    public void initId(Long id) {
        this.id = id;
    }

    // 회원 정보를 업데이트하는 메소드
    // setter 대신에 명확한 의미를 갖는 메소드로 업데이트합니다.
    public void updateMember(String name, Long phone_number) {
        this.name = name;
        this.phone_number = phone_number;
    }

}

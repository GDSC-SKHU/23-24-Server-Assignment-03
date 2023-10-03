package com.gdsc.guestbook.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Guest {

    private Long id; // 고객 고유 id
    private String name; // 고객 이름
    private String regdate; // 고객 등록 날짜

    // 무분별한 @Setter 사용 지양
    @Builder
    public Guest(String name, String regdate) {
        this.name = name;
        this.regdate = regdate;
    }

    // 기능은 setter와 동일하지만 변수명을 설정함으로써 왜 수정하는지 명확하게 알 수 있게 함
    // 실제 프로젝트에서 id 필드에 접근할 수 있는 것은 굉장히 위험
    public void initId(Long id) {
        this.id = id;
    }

    // 추가적으로 Guest 객체를 수정할 때, setter를 이용하여 필드를 하나씩 수정하기 보단 메소드를 이용하여 직관적으로 이해할 수 있게 함
    public void updateGuest(String name, String regdate) {
        this.name = name;
        this.regdate = regdate;
    }
}

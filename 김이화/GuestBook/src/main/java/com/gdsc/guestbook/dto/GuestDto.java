package com.gdsc.guestbook.dto;

import lombok.Builder;
import lombok.Data;

// 데이터를 주고 받을 때 사용
@Data
public class GuestDto {

    private Long id; // 고객 고유 id
    private String name; // 고객 이름
    private String regdate; // 고객 등록 날짜

    @Builder
    public GuestDto(Long id, String name, String regdate) {
        this.id = id;
        this.name = name;
        this.regdate = regdate;
    }
}

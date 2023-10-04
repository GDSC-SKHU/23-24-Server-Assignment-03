package com.gdsc.assignment3.dto;

import lombok.Builder;
import lombok.Data;

@Data //
public class MenuDto {
    private Long id;
    private String menuname; // 메뉴의 이름
    private String custname; // 고객의 이름

    @Builder
    public MenuDto(Long id, String menuname, String custname){
        this.id = id;
        this.menuname = menuname;
        this.custname = custname;

    }
}

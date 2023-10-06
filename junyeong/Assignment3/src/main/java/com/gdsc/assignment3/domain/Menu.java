package com.gdsc.assignment3.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Menu {

    private Long id; // 메뉴의 주문번호
    private String menuname; // 메뉴의 이름
    private String custname; // 주문 고객 이름

    @Builder // 무분별한 Setter 사용을 자제한다.
    public Menu(String menuname,String custname){
        this.menuname = menuname;
        this.custname = custname;
    }


    public void initId(Long id){
        this.id = id;
    }
    public void updateMenu(String menuname,String custname){
        this.menuname = menuname;
        this.custname = custname;
    }

}

package com.starbucks.cafeordermanagement.domain;

import lombok.Builder;
import lombok.Getter;

// 카페 주문 메뉴
@Getter
public class Order {
    private Long id; // 주문 id
    private String name; // 주문 메뉴 이름
    private Long count; // 주문 개수
    private String customer; // 고객 이름

    @Builder
    public Order(String name, Long count, String customer) {
        this.name = name;
        this.count = count;
        this.customer = customer;
    }

    public void initId(Long id) {
        this.id = id;
    }

    public void updateOrder(String name, Long count, String customer) {
        this.name = name;
        this.count = count;
        this.customer = customer;
    }
}

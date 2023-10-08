package com.starbucks.cafeordermanagement.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class OrderDto {
    private Long id;
    private String name;
    private Long count;
    private String customer;

    @Builder
    public OrderDto(Long id, String name, Long count, String customer) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.customer = customer;
    }
}

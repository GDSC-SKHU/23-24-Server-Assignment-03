package com.example.gdsc_hw03.domain;

import lombok.Builder;
import lombok.Getter;


@Getter
public class Book {
    private Long id; // 도서 번호
    private String name; // 도서명
    private Long count; // 도서 수

    @Builder
    public Book(String name, Long count){
        this.name=name;
        this.count=count;
    }

    public void initId(Long id){
        this.id = id;
    }

    public void updateBook(String name, Long count){ // Book 객체를 수정
        this.name=name;
        this.count=count;
    }
}

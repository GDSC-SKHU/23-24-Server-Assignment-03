package com.example.gdsc_hw03.dto;
import com.example.gdsc_hw03.domain.Book;

import lombok.Builder;
import lombok.Data;

@Data
public class BookDto {
    private Long id; // 도서 번호
    private String name; // 도서명
    private Long count; // 도서 수

    @Builder
    public BookDto(Long id, String name, Long count) {
        this.id = id;
        this.name = name;
        this.count = count;

    }
}



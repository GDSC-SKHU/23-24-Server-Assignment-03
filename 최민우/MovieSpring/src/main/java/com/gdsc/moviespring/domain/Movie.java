package com.gdsc.moviespring.domain;

import com.gdsc.moviespring.dto.MovieDto;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Movie {

    private Long id;
    private String name;
    private String theater;
    private String location;

    @Builder
    public Movie(Long id, String name, String theater, String location) {
        this.id = id;
        this.name = name;
        this.theater = theater;
        this.location = location;
    }

    // 의미가 불분명한 setter 대신 이해하기 쉬운 메소드 이름을 지어줘요. (기능은 setter와 동일)
    public void initId(Long id) {
        this.id = id;
    }

    // Movie -> MovieDto
    // Builder를 사용해서, Movie를 MovieDto로 변환
    public MovieDto toDto() {
        return MovieDto.builder()
                .id(id)
                .name(name)
                .theater(theater)
                .location(location)
                .build();
    }
}

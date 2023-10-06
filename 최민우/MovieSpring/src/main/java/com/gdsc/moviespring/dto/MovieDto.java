package com.gdsc.moviespring.dto;

import com.gdsc.moviespring.domain.Movie;
import lombok.Builder;
import lombok.Data;

@Data
public class MovieDto {

    private Long id;
    private String name;
    private String theater;
    private String location;


    @Builder
    public MovieDto(Long id, String name, String theater, String location) {
        this.id = id;
        this.name = name;
        this.theater = theater;
        this.location = location;
    }

    // MovieDto -> Movie
    // Builder를 사용해서, MovieDto를 Movie로 변환
    public Movie toEntity() {
        return Movie.builder()
                .id(id)
                .name(name)
                .theater(theater)
                .location(location)
                .build();
    }
}

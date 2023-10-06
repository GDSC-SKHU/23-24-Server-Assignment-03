package com.pack.movielist.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class Moviedto {
    private Long id; //영화 고유 식별 id

    private String title; // 영화 제목

    private String genre; // 영화 장르

    private int movie_begin_end; // 상영시간

    @Builder
    public Moviedto(Long id, String title, String genre, int movie_begin_end){
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.movie_begin_end = movie_begin_end;
    }
}

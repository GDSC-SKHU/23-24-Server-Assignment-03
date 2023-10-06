package com.pack.movielist.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
public class Movie {
    private Long id; //영화 고유 식별 id

    private String title; // 영화 제목

    private String genre; // 영화 장르

    private int movie_begin_end; // 상영시간;

    @Builder
    public Movie(Long id,String title, String genre, int movie_begin_end){
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.movie_begin_end = movie_begin_end;
    } //builder 어노테이션으로 setter의 사용을 줄였다.


    //id 필드를 initId 같은 메소드로 '프로젝트'에서 접근하는 방법은 보안상 좋지 않다고 하였다.
    //그래서 id필드 값은 유일무이해야 하니 생성단계부터 변경하지 못하도록 하였다.

    public void updateMovie(String title, String genre, int movie_begin_end){
        this.title = title;
        this.genre = genre;
        this.movie_begin_end = movie_begin_end;
    }//하나씩 필드를 수정하는 것보다 전체적으로 수정할 수 있도록 하는 메소드


}

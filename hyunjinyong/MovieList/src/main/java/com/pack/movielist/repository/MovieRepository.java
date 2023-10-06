package com.pack.movielist.repository;

import com.pack.movielist.domain.Movie;

import java.util.List;

public interface MovieRepository {
    void save(Movie m); // 생성
    Movie findById(Long id);
    List<Movie> findAll();
    void updateById(Long id, Movie m);
    void deleteById(Long id);
}

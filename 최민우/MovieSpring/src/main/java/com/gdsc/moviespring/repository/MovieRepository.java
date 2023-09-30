package com.gdsc.moviespring.repository;

import com.gdsc.moviespring.domain.Movie;

import java.util.List;

public interface MovieRepository {

    void save(Movie movie);
    Movie findById(Long id);
    List<Movie> findAll();
    void updateById(Long id, Movie movie);
    void deleteById(Long id);
}

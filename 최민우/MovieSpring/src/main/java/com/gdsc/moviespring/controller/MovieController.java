package com.gdsc.moviespring.controller;

import com.gdsc.moviespring.dto.MovieDto;
import com.gdsc.moviespring.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("movies")
    public void save(@RequestBody MovieDto movieDto) {
        movieService.saveMovie(movieDto);
    }

    @GetMapping("movies/{id}")
    public MovieDto findMovieById(@PathVariable Long id) {
        return movieService.findMovieById(id);
    }

    @GetMapping("movies/list")
    public List<MovieDto> findAllMovie() {
        return movieService.findAllMovie();
    }

    @PatchMapping("movies/{id}")
    public void updateMovieById(@PathVariable Long id, @RequestBody MovieDto movieDto) {
        movieService.updateMovieById(id, movieDto);
    }

    @DeleteMapping("movies/{id}")
    public void deleteMovieById(@PathVariable Long id) {
        movieService.deleteMovieById(id);
    }
}

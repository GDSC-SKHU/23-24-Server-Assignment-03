package com.pack.movielist.controller;

import com.pack.movielist.dto.Moviedto;
import com.pack.movielist.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }

    @PostMapping("movies")
    public void save(@RequestBody Moviedto moviedto){
        movieService.saveMovie(moviedto);
    }

    @GetMapping("movies/{id}")
    public Moviedto findMovieById(@PathVariable Long id){
        return movieService.findMovieById(id);
    }

    @GetMapping("movies")
    public List<Moviedto> findAllMovie(){
        return movieService.findAllMovie();
    }

    @PatchMapping("movies/{id}")
    public void updateMovieById(@PathVariable Long id, @RequestBody Moviedto moviedto){
        movieService.updateMovieById(id, moviedto);
    }

    @DeleteMapping("movies/{id}")
    public void deletMovieById(@PathVariable Long id){
        movieService.deletedMoiveById(id);
    }
}

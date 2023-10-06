package com.pack.movielist.service;

import com.pack.movielist.dto.Moviedto;
import com.pack.movielist.domain.Movie;
import com.pack.movielist.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository mr;

    public MovieService(MovieRepository mr){
        this.mr = mr;
    } //의존성 생성자 주입 코드

    public void saveMovie(Moviedto moviedto){
        Movie movie = Movie.builder()
                .title(moviedto.getTitle())
                .genre(moviedto.getGenre())
                .movie_begin_end(moviedto.getMovie_begin_end())
                .build();

        mr.save(movie);
    }

    public Moviedto findMovieById(Long id){
        Movie movie = mr.findById(id);

        return Moviedto.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .genre(movie.getGenre())
                .movie_begin_end(movie.getMovie_begin_end())
                .build();
    }

    public List<Moviedto> findAllMovie(){
        return mr.findAll()
                .stream()
                .map(movie -> Moviedto.builder()
                        .id(movie.getId())
                        .title(movie.getTitle())
                        .genre(movie.getGenre())
                        .movie_begin_end(movie.getMovie_begin_end())
                        .build())
                .toList(); // 이 부분의 코드가 헷갈렸지만 DTO 객체를 생성한 후 domain의 movie의 내용을 dto객체에 저장한 후 반환한다는
        //것을 이해함. .toList 메소드는 stream 요소를 포함한 배열이 반환됨.
    }

    public void updateMovieById(Long id, Moviedto moviedto){
        Movie foundMoive = mr.findById(id);
        foundMoive.updateMovie(moviedto.getTitle(), moviedto.getGenre(), moviedto.getMovie_begin_end());
        mr.updateById(id, foundMoive);
    }

    public void deletedMoiveById(Long id){
        mr.deleteById(id);
    }




}

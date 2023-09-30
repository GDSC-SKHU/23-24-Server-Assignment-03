package com.gdsc.moviespring.service;

import com.gdsc.moviespring.domain.Movie;
import com.gdsc.moviespring.dto.MovieDto;
import com.gdsc.moviespring.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    // 의존성 생성자 주입
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public void saveMovie(MovieDto movieDto) {
        Movie movie = movieDto.toEntity(); // movieDto를 movie로 변환
        movieRepository.save(movie); // movieRepository를 통해, movie를 저장
    }

    public MovieDto findMovieById(Long id) {
        Movie movie = movieRepository.findById(id); // movieRepository를 통해, id에 해당하는 movie를 찾아서 반환

        return MovieDto.builder()
                .id(movie.getId())
                .name(movie.getName())
                .theater(movie.getTheater())
                .location(movie.getLocation())
                .build(); // movieDto 반환
    }

    // Builder를 이용한 toDto()를 통해 간결하게 만들 수 있다.
    public List<MovieDto> findAllMovie() {
        return movieRepository.findAll()
                .stream()
                .map(Movie::toDto)
                .toList(); // movieRepository를 통해 모든 movie를 찾아서 반환
    }

    public void updateMovieById(Long id, MovieDto movieDto) {
        Movie movie = movieDto.toEntity(); // movieDto를 movie로 변환
        movie.initId(id);
        movieRepository.updateById(id, movie);
    }

    public void deleteMovieById(Long id) {
        movieRepository.deleteById(id);
    }
}

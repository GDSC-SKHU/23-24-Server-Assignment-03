package com.gdsc.moviespring.repository;

import com.gdsc.moviespring.domain.Movie;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryMovieRepository implements MovieRepository {

    private static Map<Long, Movie> store = new HashMap<>(); // 저장 공간
    private static Long sequence = 0L; // id를 생성하기 위한 sequence

    @Override
    public void save(Movie movie) {
        movie.initId(++sequence); // id를 생성하고 movie에 저장
        store.put(movie.getId(), movie); // store에 저장
    }

    @Override
    public Movie findById(Long id) {
        return store.get(id); // id에 해당하는 movie를 찾아서 반환
    }

    @Override
    public List<Movie> findAll() {
        return store.values().stream().toList(); // store에 있는 모든 value를 ArrayList에 담아서 반환
    }

    @Override
    public void updateById(Long id, Movie movie) {
        store.put(id, movie); // store에 저장, hash map은 key가 같으면 덮어씌워지기 때문에 id는 그대로 두고 내용만 수정
    }

    @Override
    public void deleteById(Long id) {
        store.remove(id); // id에 해당하는 movie를 찾아서 삭제
    }
}

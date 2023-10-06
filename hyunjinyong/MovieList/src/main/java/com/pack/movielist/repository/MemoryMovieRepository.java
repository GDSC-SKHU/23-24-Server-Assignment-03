package com.pack.movielist.repository;

import com.pack.movielist.domain.Movie;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryMovieRepository implements MovieRepository {

    private static Map<Long, Movie> mList = new HashMap<>();
    //예약할 영화에 대한 정보를 담기를 위해 예제에서 사용된 hashmap을 재사용.
    private static Long seq = 0L;
    //고유한 ID 값을 위한 변수
    @Override
    public void save(Movie m) {
        mList.put(m.getId(), m); // hashmap 객체에 나머지 정보 삽입.
    }

    @Override
    public Movie findById(Long id) {
        return mList.get(id);
    }

    @Override
    public List<Movie> findAll() {
        return mList.values().stream().toList();
    }

    @Override
    public void updateById(Long id, Movie m) {
        mList.put(id, m);
    }

    @Override
    public void deleteById(Long id) {
        mList.remove(id);
    }
}

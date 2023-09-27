package com.example.gdsc_restapi.repository;

import com.example.gdsc_restapi.domain.Music;

import java.util.List;

public interface MusicRepository {
    void save(Music music);
    Music findById(Long id);
    List<Music> findAll();
    void updateById(Long id, Music music);
    void deleteById(Long id);

}

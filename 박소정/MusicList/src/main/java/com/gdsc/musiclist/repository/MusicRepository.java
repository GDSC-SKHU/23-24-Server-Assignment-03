package com.gdsc.musiclist.repository;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.gdsc.musiclist.domain.Music;

import java.util.List;

public interface MusicRepository {
    void save(Music music);
    Music findById(Long id);
    List<Music> findAll();
    void updateById(Long id, Music music);
    void deleteById(Long id);

}

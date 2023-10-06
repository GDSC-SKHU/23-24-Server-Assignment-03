package com.gdsc.musiclist.repository;

import com.gdsc.musiclist.domain.Music;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryMusicRepository implements MusicRepository{

    private static Map<Long, Music> store = new HashMap<>();
    private static Long sequence = 0L; // id를 생성하기 위한 sequence
    @Override
    public void save(Music music) {
        music.initId(++sequence); // id를 생성하고 music에 저장
        store.put(music.getId(), music);
    }

    @Override
    public Music findById(Long id) {
        return store.get(id);
    }

    @Override
    public List<Music> findAll() {
        return store.values().stream().toList(); // store에 있는 모든 value를 ArrayList에 담아서 반환
    }

    @Override
    public void updateById(Long id, Music music) {
        store.put(id, music);// store에 저장, hash map은 key가 같으면 덮어씌워지기 때문에 id는 그대로 두고 내용만 수정
    }

    @Override
    public void deleteById(Long id) {
        store.remove(id);
    }
}
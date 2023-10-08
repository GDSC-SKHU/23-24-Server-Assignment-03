package com.gdsc.musiclist.service;

import com.gdsc.musiclist.domain.Music;
import com.gdsc.musiclist.dto.MusicDto;
import com.gdsc.musiclist.repository.MusicRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MusicService {

    private final MusicRepository musicRepository;

    // 의존성 생성자 주입
    public MusicService(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    public void saveMusic(MusicDto musicDto) {
        Music music = Music.builder()
                .name(musicDto.getName())
                .artist(musicDto.getArtist())
                .build();

        musicRepository.save(music);
    }

    public MusicDto findMusicById(Long id) {
        Music music = musicRepository.findById(id);

        return MusicDto.builder()
                .id(music.getId())
                .name(music.getName())
                .artist(music.getArtist())
                .build();
    }

    public List<MusicDto> findAllMusic() {
        return musicRepository.findAll()
                .stream()
                .map(music -> MusicDto.builder()
                        .id(music.getId())
                        .name(music.getName())
                        .artist(music.getArtist())
                        .build())
                .toList();
    }

    public void updateMusicById(Long id, MusicDto musicDto) {
        Music findMusic = musicRepository.findById(id);
        findMusic.updateMusic(musicDto.getName(), musicDto.getArtist());

        musicRepository.updateById(id, findMusic); // musicRepository 대소문자 주의
    }

    public void deleteMusicById(Long id) {
        musicRepository.deleteById(id);
    }
}
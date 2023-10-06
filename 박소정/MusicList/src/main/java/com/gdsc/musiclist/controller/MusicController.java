package com.gdsc.musiclist.controller;

import com.gdsc.musiclist.dto.MusicDto;
import com.gdsc.musiclist.service.MusicService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MusicController {

    private final MusicService musicService;

    public MusicController(MusicService musicService) {
        this.musicService = musicService;
    } // 의존성 생성자 주입

    @PostMapping("music")
    public void save(@RequestBody MusicDto musicDto) {
        musicService.saveMusic(musicDto);
    }

    @GetMapping("music/{id}")
    public MusicDto findMusicById(@PathVariable Long id) {
        return musicService.findMusicById(id);
    }

    @GetMapping("music")
    public List<MusicDto> findAllMusic() {
        return musicService.findAllMusic();
    }

    @PatchMapping("music/{id}")
    public void updateMusicById(@PathVariable Long id, @RequestBody MusicDto musicDto) {
        musicService.updateMusicById(id, musicDto);
    } // id는 변경X, 제목과 아티스트만 바뀜

    @DeleteMapping("music/{id}")
    public void deleteMusicById(@PathVariable Long id) {
        musicService.deleteMusicById(id);
    }
}

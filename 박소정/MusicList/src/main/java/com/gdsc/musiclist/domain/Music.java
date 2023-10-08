package com.gdsc.musiclist.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Music {
    private Long id; // 음악 고유 id
    private String name; // 음악 제목
    private String artist; // 아티스트

    @Builder
    public Music(String name, String artist) {
        this.name = name;
        this.artist = artist;
    }

    public void initId(Long id) {
        this.id = id;
    }
    // 실제 프로젝트에서는 사용 금지

    public void updateMusic(String name, String artist) {
        this.name = name;
        this.artist = artist;
    }
}
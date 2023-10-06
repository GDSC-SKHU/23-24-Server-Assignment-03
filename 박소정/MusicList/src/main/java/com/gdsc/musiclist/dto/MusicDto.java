package com.gdsc.musiclist.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class MusicDto {
    private Long id;
    private String name;
    private String artist;

    @Builder
    public MusicDto(Long id, String name, String artist) {
        this.id = id;
        this.name = name;
        this.artist = artist;
    }

}

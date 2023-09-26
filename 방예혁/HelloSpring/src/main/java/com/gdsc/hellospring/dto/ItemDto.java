package com.gdsc.hellospring.dto;

import com.gdsc.hellospring.domain.Item;
import lombok.Builder;
import lombok.Data;

@Data
public class ItemDto {

    private Long id;
    private String name;
    private Long count;

    @Builder
    public ItemDto(Long id, String name, Long count) {
        this.id = id;
        this.name = name;
        this.count = count;
    }

    // ItemDto -> Item
    // Builder를 사용해서 ItemDto를 Item으로 변환
    public Item toEntity() {
        return Item.builder()
                .id(id)
                .name(name)
                .count(count)
                .build();
    }

}

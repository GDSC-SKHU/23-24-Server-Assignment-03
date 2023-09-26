package com.gdsc.hellospring.domain;

import com.gdsc.hellospring.dto.ItemDto;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Item {

    private Long id;
    private String name;
    private Long count;

    @Builder
    public Item(Long id, String name, Long count) {
        this.id = id;
        this.name = name;
        this.count = count;
    }

    // 의도를 명확히 하는 메소드들, setter 와 같은 역할
    public void initId(Long id) {
        this.id = id;
    }

    // Item -> ItemDto
    // Builder를 사용해서 Item을 ItemDto로 변환
    public ItemDto toDto() {
        return ItemDto.builder()
                .id(id)
                .name(name)
                .count(count)
                .build();
    }

}

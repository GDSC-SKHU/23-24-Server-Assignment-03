package com.gdsc.hellospring.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Item {

    private Long id;
    private String name;
    private Long count;

    @Builder
    public Item(String name, Long count) {
        this.name = name;
        this.count = count;
    }

    // 기능은 setter와 동일하지만 왜 수정하려는지 명확하게 알 수 있어요.
    // ** 하지만 실제 프로젝트에서 id 필드를 접근할 수 있게 하는 것은 굉장히 위험해요. 전체적인 흐름 파악을 위해 이번에만 사용하기로 해요.**
    public void initId(Long id) {
        this.id = id;
    }

    // 추가적으로 Item 객체를 수정할 때 setter로 하나씩 필드를 수정하는 것보다 updateItem 메소드를 이용하면 좀 더 직관적으로 이해할 수 있게 돼요.
    public void updateItem(String name, Long count) {
        this.name = name;
        this.count = count;
    }

}
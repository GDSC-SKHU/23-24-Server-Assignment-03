package com.gdsc.hellospring.service;

import com.gdsc.hellospring.domain.Item;
import com.gdsc.hellospring.dto.ItemDto;
import com.gdsc.hellospring.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    // MemoryItemRepository를 명시적으로 주입받지 않고, ItemRepository를 주입받음
    // 이렇게 Interface 주입 방식을 사용하면, 나중에 다른 Repository로 변경할 때, ItemService를 수정할 필요가 없음
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void saveItem(ItemDto itemDto) {
        Item item = itemDto.toEntity(); // itemDto를 item으로 변환

        itemRepository.save(item); // itemRepository를 통해 item을 저장
    }

    public ItemDto findItemById(Long id) {
        Item item = itemRepository.findById(id); // itemRepository를 통해 id에 해당하는 item을 찾아서 반환

        return ItemDto.builder()
                .id(item.getId())
                .name(item.getName())
                .count(item.getCount())
                .build(); // itemDto 반환
    }

    public List<ItemDto> findAllItem() {
        return itemRepository.findAll()
                .stream()
                .map(Item::toDto)
                .toList(); // itemRepository를 통해 모든 item을 찾아서 반환
    }

    public void updateItemById(Long id, ItemDto itemDto) {
        Item item = itemDto.toEntity(); // itemDto를 item으로 변환
        item.initId(id); // 혹시 잘못된 id가 들어왔을 경우를 대비해서 id를 초기화, 자주 사용되는 방법은 아님

        itemRepository.updateById(id, item); // itemRepository를 통해 id에 해당하는 item을 찾아서 내용을 수정
    }

    public void deleteItemById(Long id) {
        itemRepository.deleteById(id); // itemRepository를 통해 id에 해당하는 item을 찾아서 삭제
    }

}

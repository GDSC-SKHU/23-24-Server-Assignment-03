package com.gdsc.hellospring.repository;

import com.gdsc.hellospring.domain.Item;
import java.util.List;

public interface ItemRepository {

    void save(Item item);
    Item findById(Long id);
    List<Item> findAll();
    void updateById(Long id, Item item);
    void deleteById(Long id);

}

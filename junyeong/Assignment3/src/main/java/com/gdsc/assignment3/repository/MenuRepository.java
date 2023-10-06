package com.gdsc.assignment3.repository;

import com.gdsc.assignment3.domain.Menu;

import java.util.List;

public interface MenuRepository {

    void save(Menu menu);
    Menu findById(Long id);
    List<Menu> findAll();
    void updateById(Long id, Menu menu);
    void deleteById(Long id);
}

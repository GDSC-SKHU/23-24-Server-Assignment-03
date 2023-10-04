package com.gdsc.assignment3.repository;

import com.gdsc.assignment3.domain.Menu;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository // 스프링 빈 등록
public class MemoryMenuRepository implements MenuRepository{

    private static Map<Long, Menu> store = new HashMap<>(); // 저장 공간
    private static Long sequence = 0L; // id를 생성하기 위한 sequence
    @Override
    public void save(Menu menu) {
        menu.initId(++sequence); // id를 생성하고 menu에 저장
        store.put(menu.getId(),menu); // store에 저장

    }

    @Override
    public Menu findById(Long id) { // menu를 찾는 메소드
        return store.get(id); // id에 해당하는 menu를 찾아서 반환
    }

    @Override
    public List<Menu> findAll() { // 모든 menu를 찾는 메소드
        return store.values().stream().toList(); // store에 있는 모든 value를 ArrayList에 담아서 반환
    }

    @Override
    public void updateById(Long id, Menu menu) { // menu를 업데이트하는 메소드
        store.put(id,menu); // store에 저장, hash map은 key가 중복이면 덮어씌워지기 때문에 id는 그래도 두고 내용만 수정

    }

    @Override
    public void deleteById(Long id) { // menu를 삭제하는 메소드
        store.remove(id); // id에 해당하는 menu를 찾아서 삭제

    }
}

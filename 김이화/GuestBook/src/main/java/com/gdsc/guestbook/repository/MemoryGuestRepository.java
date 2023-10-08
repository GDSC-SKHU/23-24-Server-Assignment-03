package com.gdsc.guestbook.repository;

import com.gdsc.guestbook.domain.Guest;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryGuestRepository implements GuestRepository {

    private static Map<Long, Guest> store = new HashMap<>(); // 저장 공간
    private static Long sequence = 0L; // id를 생성하기 위한 sequence

    // 추상 메소드 구현
    @Override
    public void insert(Guest guest) {
        guest.initId(++sequence); // sequence 변수를 1씩 증가시켜 고유한 id값을 생성하고 guest 객체에 등록, setter가 아닌 initId 메소드 사용
        store.put(guest.getId(), guest); // hasp map에서 key에는 고유 id값, value에는 guest 객체에 담아 store에 저장
    }

    @Override
    public Guest findById(Long id) {
        return store.get(id); // id에 해당하는 guest 객체를 찾아서 반환
    }

    @Override
    public List<Guest> findAll() {
        return store.values().stream().toList(); // store(hash map)에 있는 모든 guest 객체(value)를 ArrayList에 담아서 반환
    }

    @Override
    public void updateById(Long id, Guest guest) {
        store.put(id, guest); // hash map은 key가 같을 경우, 새로운 값으로 덮어씌워지기 때문에 id는 그대로 두고 내용만 수정하여 store에 저장
    }

    @Override
    public void deleteById(Long id) {
        store.remove(id); // id에 해당하는 guest를 찾아서 삭제
    }
}

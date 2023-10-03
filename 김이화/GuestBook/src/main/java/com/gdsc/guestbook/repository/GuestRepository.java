package com.gdsc.guestbook.repository;

import com.gdsc.guestbook.domain.Guest;

import java.util.List;

// 다른 데이터베이스로 변경될 가능성이 높기 때문에 interface를 사용
public interface GuestRepository {
    void insert(Guest guest);
    Guest findById(Long id);
    List<Guest> findAll();
    void updateById(Long id, Guest guest);
    void deleteById(Long id);
}

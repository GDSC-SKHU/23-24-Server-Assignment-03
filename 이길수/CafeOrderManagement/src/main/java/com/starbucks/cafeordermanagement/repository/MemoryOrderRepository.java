package com.starbucks.cafeordermanagement.repository;

import com.starbucks.cafeordermanagement.domain.Order;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryOrderRepository implements OrderRepository {
    private static Map<Long, Order> store = new HashMap<>(); // 저장 공간
    // id를 생성하기 위한 sequence
    public static Long sequence = 0L;

    @Override
    public void save(Order order) {
        order.initId(++sequence); // id를 생성하고 order에 저장
        store.put(order.getId(), order); // store에 저장
    }

    @Override
    public Order findById(Long id) {
        return store.get(id); // id에 해당하는 order를 찾아서 변환
    }

    @Override
    public List<Order> findAll() {
        return store.values().stream().toList(); // store에 있는 모든 value를 ArrayList에 담아서 반환
    }

    @Override
    public void updateById(Long id, Order order) {
        store.put(id, order); // store에 저장, 덮어씌움
    }

    @Override
    public void deleteById(Long id) {
        store.remove(id); // id에 해당하는 order를 찾아서 삭제
    }
}

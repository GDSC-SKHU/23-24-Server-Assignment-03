package com.starbucks.cafeordermanagement.repository;

import com.starbucks.cafeordermanagement.domain.Order;

import java.util.List;

public interface OrderRepository {
    void save(Order order);
    Order findById(Long id);
    List<Order> findAll();
    void updateById(Long id, Order order);
    void deleteById(Long id);
}

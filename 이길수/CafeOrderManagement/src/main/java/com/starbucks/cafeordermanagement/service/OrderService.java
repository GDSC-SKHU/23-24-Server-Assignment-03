package com.starbucks.cafeordermanagement.service;

import com.starbucks.cafeordermanagement.domain.Order;
import com.starbucks.cafeordermanagement.dto.OrderDto;
import com.starbucks.cafeordermanagement.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    // 의존성 생성자 주입
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void saveOrder(OrderDto orderDto) {
        Order order = Order.builder()
                .name(orderDto.getName())
                .count(orderDto.getCount())
                .customer(orderDto.getCustomer())
                .build();

        orderRepository.save(order); // orderRepository를 통해 order을 저장
    }

    public OrderDto findOrderById(Long id) {
        Order order = orderRepository.findById(id); // orderRepository를 통해 id에 해당하는 order를 찾아서 반환
        
        return OrderDto.builder()
                .id(order.getId())
                .name(order.getName())
                .count(order.getCount())
                .customer(order.getCustomer())
                .build(); // orderDto 반환
    }

    public List<OrderDto> findAllOrder() {
        return orderRepository.findAll()
                .stream()
                .map(order -> OrderDto.builder()
                        .id(order.getId())
                        .name(order.getName())
                        .count(order.getCount())
                        .customer(order.getCustomer())
                        .build())
                .toList(); // orderRepository를 통해 모든 order를 찾아서 반환
    }

    public void updateOrderById(Long id, OrderDto orderDto) {
        Order findOrder = orderRepository.findById(id); // orderRepository를 통해 id에 해당하는 order를 찾아서 반환
        findOrder.updateOrder(orderDto.getName(), orderDto.getCount(), orderDto.getCustomer()); // order의 내용을 수정
        
        orderRepository.updateById(id, findOrder); // orderRepository를 통해 id에 해당하는 order를 찾아서 내용을 수정
    }

    public void deleteOrderById(Long id) {
        orderRepository.deleteById(id); // orderRepository를 통해 id에 해당하는 order를 찾아서 삭제
    }
}

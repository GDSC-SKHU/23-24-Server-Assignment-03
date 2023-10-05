package com.starbucks.cafeordermanagement.controller;

import com.starbucks.cafeordermanagement.dto.OrderDto;
import com.starbucks.cafeordermanagement.service.OrderService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CafeOrderController {
    private final OrderService orderService;

    // 의존성 생성자 주입
    public CafeOrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("orders")
    public void save(@RequestBody OrderDto orderDto) {
        orderService.saveOrder(orderDto);
    }

    @GetMapping("orders/{id}")
    public OrderDto findOrderById(@PathVariable Long id) {
        return orderService.findOrderById(id);
    }

    @GetMapping("orders")
    public List<OrderDto> findAllOrder() {
        return orderService.findAllOrder();
    }

    @PatchMapping("orders/{id}")
    public void updateOrderById(@PathVariable Long id, @RequestBody OrderDto orderDto) {
        orderService.updateOrderById(id, orderDto);
    }

    @DeleteMapping("orders/{id}")
    public void deleteOrderById(@PathVariable Long id) {
        orderService.deleteOrderById(id);
    }
}

package com.example.sportpitstore.controller;

import com.example.sportpitstore.controller.dto.OrderCreateDto;
import com.example.sportpitstore.model.Order;
import com.example.sportpitstore.service.OrderService;
import com.example.sportpitstore.repository.OrderRepository;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.util.List;
@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    public final OrderRepository orderRepository;

    @PostMapping("/api/order")
    public Order createOrder(@RequestBody OrderCreateDto createDto)throws Exception {
        return orderService.createOrder(createDto.getSportPitsId());
    }

    @GetMapping("/api/orders/{id}")
    public Order getById(@PathVariable Long id) throws Exception {
        return orderService.getById(id);
    }
    @GetMapping("/api/order")
    public List<Order> getByAll() throws Exception{
        return orderService.getByAll();
    }

    @DeleteMapping("/api/order/{id}")
    public void deleteOrder(@PathVariable Long id)throws Exception{
        orderService.deleteOrder(id);
    }

}

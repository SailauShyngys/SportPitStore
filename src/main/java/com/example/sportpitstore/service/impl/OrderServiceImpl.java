package com.example.sportpitstore.service.impl;

import com.example.sportpitstore.model.Order;
import com.example.sportpitstore.model.SportPit;
import com.example.sportpitstore.repository.OrderRepository;
import com.example.sportpitstore.service.OrderService;
import com.example.sportpitstore.service.SportPitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public  class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final SportPitService sportPitService;


    @Override
    public Order getById(Long id) throws Exception {
        return orderRepository.findById(id).orElseThrow();
    }
    @Override
    public List<Order> getByAll() throws Exception {
        return orderRepository.findAll().stream().toList();
    }

    @Override
    public  Order createOrder(List<Long> ids) throws Exception {
        Order order = new Order();
        List<SportPit> sportPits = new ArrayList<>();

        for (Long in : ids) {
            sportPits.add(sportPitService.getById(in));
        }

        int sum = orderSum(sportPits);

        order.setOrderSportPits(sportPits);
        order.setSum(sum);

        return orderRepository.save(order);
    }
    private int orderSum(List<SportPit> sportPits) {
        int sum = 0;

        for (SportPit sportPit : sportPits) {
            sum += sportPit.getPrice() * sportPit.getQuantity();
        }

        return sum;
    }
    @Override
    public void deleteOrder(Long id){
        orderRepository.deleteById(id);
    }
}
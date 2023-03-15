package com.example.sportpitstore.service;

import com.example.sportpitstore.controller.dto.OrderCreateDto;
import com.example.sportpitstore.model.Order;

import java.util.List;

public interface OrderService {
    Order getById(Long id)throws Exception;
    List<Order> getByAll()throws Exception;
    Order createOrder(List<Long> id) throws  Exception;
    void deleteOrder(Long id)throws Exception;
}

package com.example.sportpitstore.repository;

import com.example.sportpitstore.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Order, Long> {
}
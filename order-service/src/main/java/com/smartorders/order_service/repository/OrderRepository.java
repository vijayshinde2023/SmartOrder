package com.smartorders.order_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartorders.order_service.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
package com.smartorders.order_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartorders.order_service.dto.Inventory;
import com.smartorders.order_service.dto.ReduceStockRequest;
import com.smartorders.order_service.entity.Order;
import com.smartorders.order_service.inventory.InventoryClient;
import com.smartorders.order_service.repository.OrderRepository;

@RestController
@RequestMapping("/api/orders")
public class OrderController {


    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private InventoryClient inventoryClient;

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody Order order) {
    	Inventory inventory = inventoryClient.checkStock(order.getProductName());

        if (inventory.getAvailableQuantity() >= order.getQuantity()) {
            // Reduce stock
            ReduceStockRequest reduceRequest = new ReduceStockRequest(order.getProductName(), order.getQuantity());
            ResponseEntity<String> reduceResponse = inventoryClient.reduceStock(reduceRequest);

            if (reduceResponse.getStatusCode().is2xxSuccessful()) {
                Order saved = orderRepository.save(order);
                return ResponseEntity.ok(saved);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to reduce stock");
            }
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Not enough stock for " + order.getProductName());
        }
    }

    @GetMapping
    public List<Order> getAll() {
        return orderRepository.findAll();
    }
}


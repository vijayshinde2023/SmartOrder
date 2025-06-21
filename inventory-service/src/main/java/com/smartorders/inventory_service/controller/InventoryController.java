package com.smartorders.inventory_service.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartorders.inventory_service.dto.ReduceStockRequest;
import com.smartorders.inventory_service.entity.Inventory;
import com.smartorders.inventory_service.repository.InventoryRepository;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    private InventoryRepository inventoryRepository;

    @GetMapping("/{product}")
    public ResponseEntity<Inventory> getByProduct(@PathVariable String product) {
        return inventoryRepository.findByProductName(product)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Inventory createInventory(@RequestBody Inventory inventory) {
        return inventoryRepository.save(inventory);
    }
    
    @PutMapping("/reduce")
    public ResponseEntity<String> reduceStock(@RequestBody ReduceStockRequest request) {
        Optional<Inventory> inventoryOpt = inventoryRepository.findByProductName(request.getProductName());

        if (inventoryOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }

        Inventory inventory = inventoryOpt.get();
        if (inventory.getAvailableQuantity() < request.getQuantity()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Insufficient stock");
        }

        inventory.setAvailableQuantity(inventory.getAvailableQuantity() - request.getQuantity());
        inventoryRepository.save(inventory);

        return ResponseEntity.ok("Stock reduced successfully");
    }
}


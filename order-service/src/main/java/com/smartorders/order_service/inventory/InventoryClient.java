package com.smartorders.order_service.inventory;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.smartorders.order_service.dto.Inventory;
import com.smartorders.order_service.dto.ReduceStockRequest;
import com.smartorders.order_service.fallback.InventoryClientFallback;


@FeignClient(
	    name = "inventory-service",
	    fallback = InventoryClientFallback.class
	)
public interface InventoryClient {
    @GetMapping("/api/inventory/{product}")
    Inventory checkStock(@PathVariable("product") String productName);
    
    @PutMapping("/api/inventory/reduce")
    ResponseEntity<String> reduceStock(@RequestBody ReduceStockRequest request);
}

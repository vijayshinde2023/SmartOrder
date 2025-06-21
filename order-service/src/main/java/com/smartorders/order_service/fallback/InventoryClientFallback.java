package com.smartorders.order_service.fallback;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.smartorders.order_service.dto.Inventory;
import com.smartorders.order_service.dto.ReduceStockRequest;
import com.smartorders.order_service.inventory.InventoryClient;

@Component
public class InventoryClientFallback implements InventoryClient {
	
	@Override
	public Inventory checkStock(String productName) {
		System.out.println("⚠️ Fallback triggered: Inventory Service is down");

		// You can return a default object or handle accordingly
		Inventory fallbackInventory = new Inventory();
		fallbackInventory.setProductName(productName);
		fallbackInventory.setAvailableQuantity(0); // default/failure value
		return fallbackInventory;
	}

	    @Override
	    public ResponseEntity<String> reduceStock(ReduceStockRequest request) {
	        System.out.println("⚠️ Fallback: Cannot reduce stock, inventory service down");
	        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
	                             .body("Fallback: Inventory service is not available.");
	    }
}
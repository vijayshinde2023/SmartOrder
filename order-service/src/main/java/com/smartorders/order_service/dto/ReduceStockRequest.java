package com.smartorders.order_service.dto;

public class ReduceStockRequest {
	private String productName;
    private int quantity;
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public ReduceStockRequest(String productName, int quantity) {
		super();
		this.productName = productName;
		this.quantity = quantity;
	}
    
    
}

package com.smartorders.order_service.dto;

public class Inventory {
	 private String productName;
	    private int availableQuantity;
		public Inventory(String productName, int availableQuantity) {
			super();
			this.productName = productName;
			this.availableQuantity = availableQuantity;
		}
		public Inventory() {
			// TODO Auto-generated constructor stub
		}
		public String getProductName() {
			return productName;
		}
		public void setProductName(String productName) {
			this.productName = productName;
		}
		public int getAvailableQuantity() {
			return availableQuantity;
		}
		public void setAvailableQuantity(int availableQuantity) {
			this.availableQuantity = availableQuantity;
		}
	    
	    
}

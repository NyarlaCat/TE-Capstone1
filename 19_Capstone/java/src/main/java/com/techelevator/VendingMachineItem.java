package com.techelevator;

public abstract class VendingMachineItem {
	
	private String name;
	private Double cost; 
	private int stock = 5; 
	private String slot;
	int totalSold = 0; 
	
	public String getName() {
		return name;
	}
	public Double getCost() {
		return cost;
	}
	
	public abstract String getDisplayOutputMessage (); 
	
	public int getStock() {
		return stock; 
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getSlot() {
		return slot;
	}
	public void setSlot(String slot) {
		this.slot = slot;
	}
	public int getTotalSold() {
		return totalSold;
	}
	public int incrementTotalSold() {
		return totalSold++; 
	}

}

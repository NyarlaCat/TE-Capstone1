package com.techelevator;

public class Drink extends VendingMachineItem {

	private String name;
	private Double cost;
	private String slot;
	
	public Drink (String productName, Double productCost, String location) {
		this.name = productName;
		this.cost = productCost;
		this.slot = location;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public Double getCost() {
		return this.cost;
	}
	
	@Override
	public String getDisplayOutputMessage() {
		return "Glug Glug, Yum!";
	}
	@Override
	public String getSlot() {
		return slot;
	}
	
}

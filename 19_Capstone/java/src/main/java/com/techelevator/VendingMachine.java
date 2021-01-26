package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map.Entry;

public class VendingMachine {

	private Inventory inventory = new Inventory();
	private Map<String, VendingMachineItem> inventoryMap = inventory.setItemMap();
	private Money vendingMachineMoney = new Money();

	public void stockMachine() {
		inventoryMap = inventory.setItemMap();
	}

	public void createProductMenu() {
		for (Entry<String, VendingMachineItem> entry : inventoryMap.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue().getName() + ", $" + entry.getValue().getCost());
		}
	}

	public String reduceStock(String itemSelection) {

		if (itemSelection.matches("[A-D][1-4]")) {
			if (inventory.getItemMap().get(itemSelection).getStock() == 0) {
				return (inventory.getItemMap().get(itemSelection).getName() + " Sold Out");
			} else {
				int itemStock = inventory.getItemMap().get(itemSelection).getStock();
				int reducedItemStock = itemStock;

				if (itemStock > 0) {
					reducedItemStock = (itemStock - 1);
					inventory.getItemMap().get(itemSelection).setStock(reducedItemStock);
					inventory.getItemMap().get(itemSelection).getStock();
					inventory.getItemMap().get(itemSelection).incrementTotalSold();
				}
				return (inventory.getItemMap().get(itemSelection).getName() + " ("
						+ inventory.getItemMap().get(itemSelection).getStock() + " now available)" + "\n"
						+ inventory.getItemMap().get(itemSelection).getDisplayOutputMessage());
			}
		} else
			return "Please make a valid location selection";
	}

	public String reduceUserBalance(String itemSelection) {
		if (itemSelection.matches("[A-D][1-4]")) {
			if (vendingMachineMoney.userBalance.doubleValue() < inventory.getItemMap().get(itemSelection).getCost()) {
				return "More funds are necessary to purchase this item, please feed money into the Vending Machine.";
			} else if (vendingMachineMoney.userBalance.doubleValue() > inventory.getItemMap().get(itemSelection)
					.getCost()) {
				vendingMachineMoney.makeTransaction((inventory.getItemMap().get(itemSelection).getCost()));
				return ("Your new balance is: $" + vendingMachineMoney.userBalance);
			}
			return "Please make a valid location selection";
		}
		return "Please make a valid location selection";
	}

	public String returnChange(BigDecimal userBalance) {
		return vendingMachineMoney.getChange();
	}

	public BigDecimal callUserBalance() {
		return vendingMachineMoney.userBalance;
	}

	public BigDecimal feedMoney(String additionalFunds) {
		vendingMachineMoney.userBalance = vendingMachineMoney.userBalance
				.add(BigDecimal.valueOf(Double.parseDouble(additionalFunds)));
		return vendingMachineMoney.userBalance;
	}

	public String callItemAtSlot(String itemSelection) {
		if (itemSelection.matches("[A-D][1-4]")) {
			return inventory.getItemMap().get(itemSelection).getName();
		} else
			return "Please make a valid location selection";
	}

	public Double callItemCostAtSlot(String itemSelection) {
		if (itemSelection.matches("[A-D][1-4]")) {
			return inventory.getItemMap().get(itemSelection).getCost();
		} else {
			return Double.parseDouble("Invalid input");
		}
	}

	public int callItemStockAtSlot(String itemSelection) {
		if (itemSelection.matches("[A-D][1-4]")) {
			return inventory.getItemMap().get(itemSelection).getStock();
		} else {
			return Integer.parseInt("Invalid input");
		}
	}

	public String callItemNoiseAtSlot(String itemSelection) {
		if (itemSelection.matches("[A-D][1-4]")) {
			return inventory.getItemMap().get(itemSelection).getDisplayOutputMessage();
		} else {
			return "Please make a valid location selection";
		}
	}

	public int callItemTotalSold(String itemSelection) {
		if (itemSelection.matches("[A-D][1-4]")) {
			return inventory.getItemMap().get(itemSelection).getTotalSold();
		} else {
			return Integer.parseInt("Please make a valid location selection");
		}
	}

}
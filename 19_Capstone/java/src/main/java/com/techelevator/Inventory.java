package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Inventory {

	private Map<String, VendingMachineItem> itemMap; 
	
	public Map<String, VendingMachineItem> setItemMap() {

		itemMap = new TreeMap<String, VendingMachineItem>();
		
		File inputFile = new File("vendingmachine.csv");
		Scanner inputStream = null;
 
		try {
			inputStream = new Scanner(inputFile);
		} catch (FileNotFoundException e) {
		}

		while (inputStream.hasNext()) {
			String thisCurrentLine = inputStream.nextLine();
			String [] currentLine = thisCurrentLine.split("\\|");

			String location = currentLine[0]; 
			String type = currentLine[3];
			String name = currentLine[1];
			double cost = Double.parseDouble(currentLine[2]); 

			VendingMachineItem item = null;
			
			if (type.equals("Chip")) {
				item = new Chip(name, cost, location);
			} else if (type.equals("Candy")) {
				item = new Candy(name, cost,location);
			} else if (type.equals("Gum")) {
				item = new Gum(name, cost, location);
			} else if (type.equals("Drink")) {
				item = new Drink(name, cost, location); 
			} 
			
			itemMap.put(location, item);
		}

		return itemMap; // some collection of all the items you just made in the while loop
	
	}
	
	public Map<String, VendingMachineItem> getItemMap() {
		return this.itemMap;
	}
}

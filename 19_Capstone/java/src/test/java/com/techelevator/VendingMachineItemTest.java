package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VendingMachineItemTest {
	VendingMachineItem testItem;
	@Before
	public void setup() {
		testItem = new VendingMachineItem() {
			
			@Override
			public String getDisplayOutputMessage() {
				
				return "";
			}
		};
		
	}
	
	@Test
	public void set_slot_and_get_slot_functions() {
		testItem.setSlot("H1");
		String output = testItem.getSlot();
		final String expectedOutput = "H1";
		Assert.assertEquals(expectedOutput, output);
	}
	@Test
	public void set_stock_and_get_stock_functions() {
		testItem.setStock(10);
		int output = testItem.getStock();
		final int expectedOutput = 10;
		Assert.assertEquals(expectedOutput, output);
	}
	@Test
	public void total_sold_increments_and_get_functions() {
		testItem.incrementTotalSold();
		int output = testItem.getTotalSold();
		final int expectedOutput = 1;
		Assert.assertEquals(expectedOutput, output);
	}
	@Test
	public void get_name_functions() {
		String output = testItem.getName();
		final String expectedOutput = null;
		Assert.assertEquals(expectedOutput, output);
	}
	@Test
	public void get_cost_functions() {
		Assert.assertNull(testItem.getCost());
	}
}

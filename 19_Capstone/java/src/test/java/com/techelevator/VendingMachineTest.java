package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Assert;

public class VendingMachineTest {
	
	VendingMachine testVendingMachine; 
	VendingMachineItem item; 
	
	@Before 
	public void setup () {
		testVendingMachine = new VendingMachine();
	}
	
	@Test
	public void test_vending_machine_reduce_stock_function() {
		testVendingMachine.stockMachine();
		int stockBeforeOutput = testVendingMachine.callItemStockAtSlot("A1");
		int expectedStockBefore = 5;
		testVendingMachine.reduceStock("A1");
		int stockAfterOutput = testVendingMachine.callItemStockAtSlot("A1");
		int expectedStockAfter = 4;
		Assert.assertEquals("stock before transaction should be 5", expectedStockBefore, stockBeforeOutput);
		Assert.assertEquals("Stock after purchase should be one less than full stock which is 5", expectedStockAfter, stockAfterOutput ); 
		
	}
	@Test
	public void check_stock_see_if_it_functions_and_that_the_vending_machine_is_inililized_with_stock_of_5() {
		testVendingMachine.stockMachine();
		int output = testVendingMachine.callItemStockAtSlot("A1");
		int expectedOutput = 5;
		Assert.assertEquals("Vending Machine should initilize with a stock of 5 at every object at map value", expectedOutput, output);
	}

	@Test
	public void reduce_user_balance_functions_returns_message_for_inssufficent_funds_() {
		testVendingMachine.feedMoney("1");
		
		String outputOfReduce = testVendingMachine.reduceUserBalance("A1");
		String expectedOutputOfReduce = "More funds are necessary to purchase this item, please feed money into the Vending Machine.";
		
		BigDecimal userBalance = testVendingMachine.callUserBalance();
		final BigDecimal expectedUserBalance = BigDecimal.ONE;
		
		Double itemCost = testVendingMachine.callItemCostAtSlot("A1");
		final Double expectedItemCost = 3.05;
		
		Assert.assertEquals("When there are insufficent funds for a purchase tell user", expectedOutputOfReduce, outputOfReduce);
			
	}
	
	@Test
	public void reduce_user_balance_function_reduces_the_balance_on_a_valid_menue_option() {
		testVendingMachine.feedMoney("5");
		testVendingMachine.reduceUserBalance("A1");
		
		double outputCost = testVendingMachine.callItemCostAtSlot("A1");
		final double expectedCost = 3.05;
		Assert.assertEquals("cost of item should be what we expect based on file", expectedCost, outputCost, 0.001);

		BigDecimal outputUserBalance = testVendingMachine.callUserBalance();
		final BigDecimal expectedUserBalance = BigDecimal.valueOf(1.95);
		
		Assert.assertEquals("User balanced should be reduced by the correct amount", expectedUserBalance, outputUserBalance);
	}
	
	@Test
	public void call_item_noise_at_slot_produce_correct_noise() {
		String output = testVendingMachine.callItemNoiseAtSlot("A1");
		final String expected = "Crunch Crunch, Yum!";
		Assert.assertEquals("noise of item should be what we expect based on selection", expected, output);
	
		String output2 = testVendingMachine.callItemNoiseAtSlot("THISDOESNTEXIST");
		final String expected2 = "Please make a valid location selection";
		Assert.assertEquals("noise of item should be what we expect based on selection", expected2, output2);
	}
	
	@Test
	public void call_item_name_at_slot_produce_correct_name() {
		String output = testVendingMachine.callItemAtSlot("A1");
		final String expected = "Potato Crisps";
		Assert.assertEquals("noise of item should be what we expect based on selection", expected, output);
	
		String output2 = testVendingMachine.callItemAtSlot("THISDOESNTEXIST");
		final String expected2 = "Please make a valid location selection";
		Assert.assertEquals("noise of item should be what we expect based on selection", expected2, output2);
	}
	
	@Test
	public void call_item_cost_at_slot_produce_correct_cost() {
		Double output = testVendingMachine.callItemCostAtSlot("A1");
		final Double expected = Double.valueOf(3.05);
		Assert.assertEquals("noise of item should be what we expect based on selection", expected, output, 0.001);
		}

}

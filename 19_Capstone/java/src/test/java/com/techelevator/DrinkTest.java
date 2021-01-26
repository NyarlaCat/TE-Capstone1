package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DrinkTest {
	Drink testDrink;
	@Before
	public void setup() {
		 testDrink = new Drink("Tears of my enemy", 100.00, "Y1");
	}
	
	
	@Test
	public void gum_get_name_returns_a_name() {
		String output = testDrink.getName();
		final String expectedOutput = "Tears of my enemy";
		
		Assert.assertEquals(expectedOutput, output);	
	}
	@Test
	public void gum_get_cost_returns_cost() {
		double output = testDrink.getCost();
		final double expectedOutput = 100.00;
		Assert.assertEquals(expectedOutput, output, .001);
	}
	@Test
	public void display_message_is_as_expected() {
		String output = testDrink.getDisplayOutputMessage();
		final String expectedOutput = "Glug Glug, Yum!";
		
		Assert.assertEquals(expectedOutput, output);	
	}
	@Test
	public void get_slot_gets_a_slot() {
		String output = testDrink.getSlot();
		final String expectedOutput = "Y1";
		
		Assert.assertEquals(expectedOutput, output);	
	
	}

}

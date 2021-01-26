package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import com.techelevator.Candy;

public class CandyTest {
	Candy testCandy;
	@Before
	public void setup() {
		 testCandy = new Candy("Twix", 1.75, "A5");
	}
	
	
	@Test
	public void candy_get_name_returns_a_name() {
		String output = testCandy.getName();
		final String expectedOutput = "Twix";
		
		Assert.assertEquals(expectedOutput, output);	
	}
	@Test
	public void candy_get_cost_returns_cost() {
		double output = testCandy.getCost();
		final double expectedOutput = 1.75;
		Assert.assertEquals(expectedOutput, output, .001);
	}
	@Test
	public void display_message_is_as_expected() {
		String output = testCandy.getDisplayOutputMessage();
		final String expectedOutput = "Munch Munch, Yum!";
		
		Assert.assertEquals(expectedOutput, output);	
	}
	@Test
	public void get_slot_gets_a_slot() {
		String output = testCandy.getSlot();
		final String expectedOutput = "A5";
		
		Assert.assertEquals(expectedOutput, output);	
	
	}
}


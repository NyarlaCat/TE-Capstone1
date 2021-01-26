package com.techelevator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import com.techelevator.Gum;

public class GumTest {
	Gum testGum;
	@Before
	public void setup() {
		 testGum = new Gum("Winter Mint", 0.75, "D2");
	}
	
	
	@Test
	public void gum_get_name_returns_a_name() {
		String output = testGum.getName();
		final String expectedOutput = "Winter Mint";
		
		Assert.assertEquals(expectedOutput, output);	
	}
	@Test
	public void gum_get_cost_returns_cost() {
		double output = testGum.getCost();
		final double expectedOutput = 0.75;
		Assert.assertEquals(expectedOutput, output, .001);
	}
	@Test
	public void display_message_is_as_expected() {
		String output = testGum.getDisplayOutputMessage();
		final String expectedOutput = "Chew Chew, Yum!";
		
		Assert.assertEquals(expectedOutput, output);	
	}
	@Test
	public void get_slot_gets_a_slot() {
		String output = testGum.getSlot();
		final String expectedOutput = "D2";
		
		Assert.assertEquals(expectedOutput, output);	
	
	}
}


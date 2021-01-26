package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ChipTest {
	
		Chip testChip;
		@Before
		public void setup() {
			 testChip = new Chip("Dorito", 3.50, "B7");
		}
		
		
		@Test
		public void gum_get_name_returns_a_name() {
			String output = testChip.getName();
			final String expectedOutput = "Dorito";
			
			Assert.assertEquals(expectedOutput, output);	
		}
		@Test
		public void gum_get_cost_returns_cost() {
			double output = testChip.getCost();
			final double expectedOutput = 3.50;
			Assert.assertEquals(expectedOutput, output, .001);
		}
		@Test
		public void display_message_is_as_expected() {
			String output = testChip.getDisplayOutputMessage();
			final String expectedOutput = "Crunch Crunch, Yum!";
			
			Assert.assertEquals(expectedOutput, output);	
		}
		@Test
		public void get_slot_gets_a_slot() {
			String output = testChip.getSlot();
			final String expectedOutput = "B7";
			
			Assert.assertEquals(expectedOutput, output);	
		
		}


}

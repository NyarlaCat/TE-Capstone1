package com.techelevator.view;

import java.math.BigDecimal;

import org.junit.Test;

import com.techelevator.Money;

import org.junit.Assert;

public class MoneyTest {

	@Test
	public void test_change_rounding() {
		Money newMoney = new Money(BigDecimal.valueOf(10.9684738499484857676738));
		final String expected = "Your change due is: " + BigDecimal.valueOf(10.97);
		String output = newMoney.getChange();
		
		Assert.assertTrue(expected.contains("10.97"));
		
	}
	@Test 
	public void test_transaction_() {
		Money newMoney = new Money(BigDecimal.valueOf(10.00));
		final BigDecimal expected = BigDecimal.valueOf(8.50);
		BigDecimal output = newMoney.makeTransaction(1.50);
		
		Assert.assertEquals(expected, output);
	
	}
	@Test
	public void test_get_balance() {
		Money newMoney = new Money(BigDecimal.valueOf(5.00));
		final BigDecimal expected = BigDecimal.valueOf(5.00);
		final int expectedComparrison = 0;
		
		BigDecimal output = newMoney.getUserBalance();
		int outputCompare = expected.compareTo(output);
		
		Assert.assertEquals(expectedComparrison, outputCompare);
	}
	
	@Test
	public void test_balance_set_to_Zero_after_change_is_made() {
		Money newMoney = new Money(BigDecimal.valueOf(5.00));
		
		final BigDecimal expected = BigDecimal.valueOf(0.00);
		final int expectedComparrison = 0;
		
		newMoney.getChange();
		
		BigDecimal output =newMoney.getUserBalance();
		
		int outputCompare = expected.compareTo(output);
		
		Assert.assertEquals(expectedComparrison, outputCompare);
	}
	
}

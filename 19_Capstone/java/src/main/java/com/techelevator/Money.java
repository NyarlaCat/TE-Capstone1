package com.techelevator;

import java.math.BigDecimal;

public class Money {

	public BigDecimal userBalance;

	// default constructor
	public Money() {
		userBalance = BigDecimal.ZERO;
	}

	public Money(BigDecimal dollars) {
		userBalance = dollars;
	}

	// get balance
	public BigDecimal getUserBalance() {
		userBalance = userBalance.setScale(2, BigDecimal.ROUND_HALF_EVEN);
		return userBalance;
	}

	public BigDecimal addFundsToBalance(String additionalFunds) {
		userBalance = userBalance.add(BigDecimal.valueOf(Double.parseDouble(additionalFunds)));

		return userBalance;
	}

	// method for subtracting the item cost
	public BigDecimal makeTransaction(Double itemCost) {
		BigDecimal convertedToBigDecimal = BigDecimal.valueOf(itemCost);
		userBalance = userBalance.subtract(convertedToBigDecimal);
		return userBalance;
	}

	// get change
	public String getChange() {
		BigDecimal changeThisAmount = userBalance.setScale(2, BigDecimal.ROUND_HALF_EVEN);
		if (changeThisAmount.compareTo(BigDecimal.ZERO) > 0) {
			String changeSplit = parseDollarsToPenny(changeThisAmount);

			userBalance = BigDecimal.ZERO;
			return "Your change due is: " + changeThisAmount + "\n" + changeSplit + "\nThanks for your buisness!";
		} else {
			return "Goodbye";
		}

	}

	// helper
	private String parseDollarsToPenny(BigDecimal moneyToChange) {
		BigDecimal change = BigDecimal.valueOf(100).multiply(moneyToChange);
		int cents = change.intValue();
		int quarters = 0;
		int dimes = 0;
		int nickels = 0;
		int pennies = 0;

		quarters = (cents / 25);
		if (cents != 0) {
			cents = cents - (quarters * 25);
		}
		dimes = (cents / 10);
		cents %= 10;
		nickels = (cents / 5);
		cents %= 5;
		
		pennies = cents; 

		String changeReturned = ("Your change is returned as:\n" + quarters + " quarter(s)\n" + dimes + " dime(s)\n"
				+ nickels + " nickel(s)\n" + pennies + " pennies");
		return changeReturned;
	}

}

package com.techelevator.view;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;
import com.techelevator.Inventory;
import com.techelevator.VendingMachine;
import com.techelevator.VendingMachineItem;

public class Menu {

	private PrintWriter out;
	private Scanner in;
	private VendingMachine vendingMachine; 

	public Menu(InputStream input, OutputStream output) {
		this.out = new PrintWriter(output);
		this.in = new Scanner(input); 
	}
	
	public void setVendingMachine(VendingMachine machine) {
		this.vendingMachine = machine;
	}

	public void setUpVendingMachine() {
		this.vendingMachine.stockMachine();
		this.vendingMachine.createProductMenu();
	}

	public Object getChoiceFromOptions(Object[] options) {//we didn't write this
		Object choice = null;
		while (choice == null) {
			displayMenuOptions(options);
			choice = getChoiceFromUserInput(options);
		}
		return choice;
	}

	private Object getChoiceFromUserInput(Object[] options) {//we didn't write this
		Object choice = null;
		String userInput = in.nextLine();
		try {
			int selectedOption = Integer.valueOf(userInput);
			if (selectedOption > 0 && selectedOption <= options.length) {
				choice = options[selectedOption - 1];
			}
		} catch (NumberFormatException e) {
			// eat the exception, an error message will be displayed below since choice will
			// be null
		}
		if (choice == null) {
			out.println("\n*** " + userInput + " is not a valid option ***\n");
		}
		return choice;
	}

	private void displayMenuOptions(Object[] options) {//provided looping around to ask for input
		out.println();
		for (int i = 0; i < options.length; i++) {
			int optionNum = i + 1;
			out.println(optionNum + ") " + options[i]);
		}
		out.print("\nPlease choose an option >>> ");
		out.flush();
	}

	public String userFeedMoney() {
		String userMoneyFeedAmount = "";
		try {
			userMoneyFeedAmount = in.nextLine();
			Integer moneyFeedString = Integer.parseInt(userMoneyFeedAmount);

			if (moneyFeedString == 1 || moneyFeedString == 2 || moneyFeedString == 5 || moneyFeedString == 10) {
				out.println("Thank You For inserting $" + moneyFeedString + ".00");
						this.vendingMachine.feedMoney(userMoneyFeedAmount);
						return userMoneyFeedAmount; 
			} else {
				out.println("Please Insert Valid Currency");
			}
		} catch (NullPointerException e) {
			out.println("TRY AGAIN");
		} catch (NumberFormatException e) {
			out.println("TRY AGAIN");
			out.println("Please Insert Valid Currency");
		}
		 return "0";
	}
	
	public String userInput() {
		String userInput = null;
		
		try {
			userInput = in.nextLine();
		
		if (userInput.matches("[A-D][1-4]")) {
				return userInput;
		} 
		} catch (NullPointerException f) {
		}
		return userInput; 
	}


}

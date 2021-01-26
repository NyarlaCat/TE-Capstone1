package com.techelevator;

import java.math.BigDecimal;

import com.techelevator.view.Menu;

public class VendingMachineCLI {

	private VendingMachine vendingMachine = new VendingMachine(); 
	private Menu menu; 
	private Log machineLog = new Log();
	private SalesReport salesReport;
	
	
	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE };
	private static final String[] PURCHASING_MENU_OPTIONS = { "Feed Money", "Select Product", "Finish Transaction"};
	
	public VendingMachineCLI(Menu menu) {
		vendingMachine.stockMachine();
		this.menu = menu; 
		this.menu.setVendingMachine(vendingMachine);
	}

	public void run() {
		 
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				vendingMachine.createProductMenu();
	
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				purchase();
			}
		}
	}
	public void purchase() {
		String choice = "";
		choice = (String) menu.getChoiceFromOptions(PURCHASING_MENU_OPTIONS);
		
		while (true) {
			if (choice.equals("Select Product")) {
				vendingMachine.createProductMenu(); 
				System.out.println("Your current balance is: $" + vendingMachine.callUserBalance());
				System.out.println("\n Please select a product above using its slot identifier: ");
				System.out.println("");
				//log, string log type name of selection, send balance to log
		 		
				String userProductSelection = menu.userInput();
				machineLog.logTransactionOpen(vendingMachine.callItemAtSlot(userProductSelection), vendingMachine.callUserBalance());
				System.out.println(vendingMachine.reduceUserBalance(userProductSelection));
				System.out.println(vendingMachine.reduceStock(userProductSelection));
				//make purchase set the  user balance into the log
				machineLog.logTransactionClose(vendingMachine.callUserBalance());
				//salesReport.salesReportOpen(vendingMachine.callItemAtSlot(userProductSelection), vendingMachine.callItemTotalSold(userProductSelection));
				choice = (String) menu.getChoiceFromOptions(PURCHASING_MENU_OPTIONS); 
				
			}
			else if (choice.equals("Feed Money")) {
				//log, string log type, get the user balance to send 
				machineLog.logTransactionOpen(choice, vendingMachine.callUserBalance());
				System.out.println("Please insert money now. Enter whole dollar amounts, ($1.00's, $5,00's, $10,00's, etc.) one bill at a time.");
				menu.userFeedMoney(); 
				System.out.println("Your current balance is: $" + vendingMachine.callUserBalance()); 
				//log gets the user balance sent to it 
				machineLog.logTransactionClose(vendingMachine.callUserBalance());
				choice.equals("");
				break;
			}
			else if (choice.equals("Finish Transaction")){
				machineLog.logTransactionOpen(choice, vendingMachine.callUserBalance());
				System.out.println(vendingMachine.returnChange(vendingMachine.callUserBalance())); 
				machineLog.logTransactionClose(vendingMachine.callUserBalance());
				System.exit(0);
			}
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}

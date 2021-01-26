package com.techelevator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class SalesReport {

	private SimpleDateFormat time = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	private Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	private File salesReport = new File("SalesReport" + time.format(timestamp));
	private int totalDollarsSold; 
	
	public void salesReportOpen(String vendingMachineItemName, int totalSold) {
		//needs to make a file to append	
		try {
			salesReport.createNewFile();
		} catch (IOException e) {
			//eat the exception	
		}
		
		FileWriter writer; 
		try {
			writer = new FileWriter(salesReport, true); 
			PrintWriter printer = new PrintWriter(writer); 
			
			printer.print(vendingMachineItemName + " | " + totalSold);
			printer.print("Total Sales: $" + totalDollarsSold);
			printer.flush();
			printer.close();
		}
		catch (IOException e) {
		}
		catch (NullPointerException f) {
			
		}
		
	}
	
	
	
}

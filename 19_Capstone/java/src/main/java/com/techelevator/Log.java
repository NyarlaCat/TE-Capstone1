package com.techelevator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Log {
	private SimpleDateFormat time = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	private Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	private File logFile = new File("Log.txt");
	
	public void logTransactionOpen(String logType, BigDecimal userBalance) {
		//needs to make a file to append	
		try {
			logFile.createNewFile();
		} catch (IOException e) {
			//eat the exception	
		}
		
		
		FileWriter writer;
		try {
			writer = new FileWriter(logFile, true);
			PrintWriter printer = new PrintWriter(writer);
		//NEW LINE prints the time stamp 
			printer.print("\n" + time.format(timestamp) + " ");
		//prints the log type
			printer.print(logType + " ");
		//prints the user balance before
			printer.print(userBalance.toString()+ " ");
		//flush
			printer.flush();
			
		} catch (IOException e) {
			//eat exception
		}	
		
	}
	
	public void logTransactionClose(BigDecimal userBalance) {
		//gets the user balance  after
		try {
			logFile.createNewFile();
		} catch (IOException e) {
			//eat the exception	
		}
		
		FileWriter writer;
		try {								//true for append
			writer = new FileWriter(logFile, true);
			PrintWriter printer = new PrintWriter(writer);
		//prints the user balance after
			printer.print(userBalance.toString() + " ");
		//closes buffer
			printer.close();
			
		} catch (IOException e) {
			//eat exception
		}	
		
	}
   // System.out.println(time.format(timestamp));
    
    

}

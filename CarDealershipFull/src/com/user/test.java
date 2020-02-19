package com.user;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;

public class test {
	

	

	public static void main(String[] args) throws ParseException {
		
		/* Scanner in = new Scanner(System.in);
		
		Date today = Calendar.getInstance().getTime(); 
		System.out.println(today);
		
		
		String date1 = in.next();
		//String date2 = in.next();
		
		Date purchaseDate = new SimpleDateFormat("MM/dd/yyyy").parse(date1);
		
		System.out.println(purchaseDate);
		//Date purchase2 = new SimpleDateFormat("MM/dd/yyyy").parse(date2);
		//System.out.println(purchase2);
		
		
		
		System.out.println(ChronoUnit.DAYS.between(purchaseDate.toInstant(), today.toInstant()));
		*/


			
			Date today = Calendar.getInstance().getTime(); 
			Car car = new Car();
			
			String dateTest = "06/01/1995";
			car.setDateAdded(car.lotDate(dateTest)); ;
			
			//today = new SimpleDateFormat("MM/dd/yyyy");
			
			//System.out.println(ChronoUnit.DAYS.between(car.getDateAdded().toInstant(), today.toInstant()));
	
		
	}

}

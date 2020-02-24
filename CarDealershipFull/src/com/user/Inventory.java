package com.user;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Inventory {
	
	Car carAdd = new Car();
	ArrayList<Car> lot = new ArrayList<Car>();
	
	
	public Inventory() {}
	
	
	public ArrayList<Car> getLot() {
		return lot;
	}

	public void setLot(ArrayList<Car> lot) {
		this.lot = lot;
	}

	public Car getCarAdd() {
		return carAdd;
	}

	public void setCarAdd(Car carAdd) {
		this.carAdd = carAdd;
	}
	
	// adds a car to an ArrayList called Lot
	public static ArrayList<Car> addToLot(Car newCar, ArrayList<Car> priorlot){
		
		ArrayList<Car> lot = priorlot;
		
		lotPriceCheck(newCar);
		
		lot.add(newCar);
		
		return lot;
	}
	
	
	/* checks the price of the car and adjusts it 
	* based on the days in the lot
	*/
	public static void lotPriceCheck(Car car) {
	
		Date today = Calendar.getInstance().getTime(); 
		if(ChronoUnit.DAYS.between(car.getDateAdded().toInstant(), today.toInstant()) >= 120) {
			
			double currentPrice = car.getPrice();
			car.setPrice(currentPrice - (currentPrice * 0.10));
		}
		
	}
	
	
	// Prints the sales report
	public static void printSalesReport() {
		final String path = "/Users/richardnava/Documents/dealership-files/";

		String content = "";
		try {
			
			File carFile = new File(path + "Car_Transactions.txt");
			Scanner reader = new Scanner(carFile);
			while(reader.hasNextLine()) {
				String data = reader.nextLine();
				//System.out.println("first " + data);
				content += data; 
			}
	
			reader.close();
		}catch(FileNotFoundException e) {
			
			//System.out.println("error");
			e.printStackTrace();
		}
		
		//split file into cars
		String[] eachCar = content.split("--");
		
		ArrayList<Car> lot = new ArrayList<>();
		
		//add cars into ArrayList Lot
		
		for(int i=0;i<eachCar.length; i++) {
			
			
			String[] carParams = eachCar[i].split(",");
		
			for(int j=0;j<carParams.length;j++) {
				
				System.out.println(carParams[j].toString());
			}
			
			String make = carParams[0];
			String model = carParams[1];
			String vin = carParams[2];
			int year = Integer.parseInt(carParams[3]);
			String color = carParams[4];
			double price = Double.parseDouble(carParams[5]);
			String datePurchased = carParams[6];
			
			String[] buyerParams = carParams[7].split(" ");
			String fname = buyerParams[0].toString() ;
			String lname = buyerParams[1].toString() ;
			String email = buyerParams[2].toString() ;
			String phone = buyerParams[3].toString() ;
			String street = buyerParams[4].toString() + buyerParams[5].toString() + buyerParams[6].toString();
			String state = buyerParams[7].toString();
			String city = buyerParams[8].toString();
			String zip = buyerParams[9].toString();
			
			BuyerAddress address = new BuyerAddress(street, city, state, zip);
			Buyer buyer = new Buyer(fname, lname, email, phone, address);
			
			Car newCar = new Car(make,model,vin,year,color,price,datePurchased,buyer);
			
			
			lot.add(newCar);
			
			// create a new file titled with today's date that displays the current sales report
			Date today = Calendar.getInstance().getTime();
	
			try {
				File lotFile = new File("SalesTransactions" + today + ".txt");
				if(lotFile.createNewFile()) {
					System.out.println("file created");
				} 
				
			} catch (IOException e) {
				System.out.println("An error occurred");
			}
			
			try {
				//final String path = "/Users/richardnava/Documents/dealership-files/";
				String fileName = path + "SalesTransactions" + today + ".txt";
				FileWriter fstream = new FileWriter(fileName, true);
				try(BufferedWriter bw = new BufferedWriter(fstream)) {	
				bw.write(newCar.reportFormat());
				bw.close();
				}
			}
			catch(IOException e) {
				System.out.println("Error writing to file");
			}
			
		}
	}
}

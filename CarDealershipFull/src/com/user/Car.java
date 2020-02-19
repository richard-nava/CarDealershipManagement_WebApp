package com.user;

import java.awt.image.RenderedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.time.temporal.ChronoUnit;


import javax.imageio.ImageIO;

public class Car implements Serializable {

	private static final long serialVersionUID = 1L;
	private String description, make, model, vin, color;
	private double price; 
	private int miles, daysInLot, year, mpg, hwy;
	File image; 
	Buyer buyer;
	Date date;
	String dateAddedInString;
	String dateSoldInString;
	private boolean used = true; 
	private boolean forSale = true;
	private Date dateAdded; 
	private Date datePurchased; 
	public static final String path = "/Users/richardnava/Documents/dealership-files/";
	Search search = new Search();
	
	
	public Car() {}
	
	// constructor for view sold inventory
	public Car(String make, String model, String vin, int year, String color, double price, String dateSoldInString, Buyer buyer) {
		
		this.make = make;
		this.model = model;
		this.year = year; 
		this.color = color;
		this.price = price;
		this.dateSoldInString = dateSoldInString;
		this.buyer = buyer;
		this.vin = vin;
		
	}
	
	
	
	
	public Car(String make, String model, String vin, 
			String color, double price, int year
			,int mpg, int hwy, boolean used, int miles, int daysInLot, Buyer buyer) {
		
		
		
		
		
		this.make = make;
		this.model = model;
		this.year = year; 
		this.color = color;
		this.price = price;
		this.year = year;
		this.mpg = mpg; 
		this.hwy = hwy; 
		this.used = used;
		this.miles = miles; 
		this.vin = vin;
		this.daysInLot = daysInLot;
		this.buyer = buyer;
	}
	
	public Car(String make, String model, String vin, 
			String color, double price, int year
			,int mpg, int hwy, boolean used, int miles, int daysInLot) {
		
		
		
		// FILL THIS IN
		
		this.make = make;
		this.model = model;
		this.year = year; 
		this.color = color;
		this.price = price;
		this.year = year;
		this.mpg = mpg; 
		this.hwy = hwy; 
		this.used = used;
		this.miles = miles; 
		this.vin = vin;
		this.daysInLot = daysInLot;
	
	}
	
	public Car(String make, String model, String vin, 
			String color, double price, int year
			,int mpg, int hwy, boolean used, int miles, String dateAddedInString) {
		
		
		

		
		this.make = make;
		this.model = model;
		this.year = year; 
		this.color = color;
		this.price = price;
		this.year = year;
		this.mpg = mpg; 
		this.hwy = hwy; 
		this.used = used;
		this.miles = miles; 
		this.vin = vin;
		this.dateAddedInString = dateAddedInString;
	
	}
	
	public Car(String make, String model, String vin, 
			String color, double price, int year
			,int mpg, int hwy, boolean used, int miles, String dateAddedInString, boolean forSale) {
		
		
		
	
		
		this.make = make;
		this.model = model;
		this.year = year; 
		this.color = color;
		this.price = price;
		this.year = year;
		this.mpg = mpg; 
		this.hwy = hwy; 
		this.used = used;
		this.miles = miles; 
		this.vin = vin;
		this.dateAddedInString = dateAddedInString;
		this.forSale = forSale;
	
	}
	
	
	public Car(String make, String model, int year, String color) {
		
		this.make = make;
		this.model = model;
		this.year = year; 
		this.color = color;
		
	}
	
	
	// constructor for getSoldInventory array
	public Car(String make, String model, int year, String color, double price, Buyer buyer) {
		
		this.make = make;
		this.model = model;
		this.year = year; 
		this.color = color;
		this.price = price;
		this.buyer = buyer;
	}
	
	
	public Car(String make, String model, int year, String color, double price, String dateSoldInString,
			Buyer buyer) {
		
		this.make = make;
		this.model = model;
		this.year = year; 
		this.color = color;
		this.price = price;
		this.dateSoldInString = dateSoldInString;
		this.buyer = buyer;
		
	}

	public void saveToFile() {
		
		String fileName = path + "Car_Lot.txt";
		
		ArrayList<Car> newcar = new ArrayList<>();
		
		String list = Arrays.toString(newcar.toArray()).replace("[", "").replace("]", "");

		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(path));
			bw.write(formatData());
			bw.close();
		}catch(IOException e) {
			System.out.println("Error writing to file");
		}
		
		
	}
	
	
	 public void saveImage(File img) {
	 
	 
	 File outputfile = null; 
	 RenderedImage bufferedImage = null; 
	 try {
	 ImageIO.write(bufferedImage, "jpg", outputfile); } catch (IOException e) {
	 
	 e.printStackTrace(); } }
	 
	
	
	
	public String formatData() {
		// TODO Auto-generated method stub
		return this.make + " " + this.model + " " 
					+ this.year + " " + this.color 
					+ " " + this.mpg + " " + this.hwy + " "
					+ this.used + this.miles + "\n"; 
	}

	public Buyer getBuyer() {
		return buyer;
	}
	
	public void setBuyer(Buyer buyer) {
	
		this.buyer = buyer;
	}
	

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public boolean isForSale() {
		return forSale;
	}

	public void setForSale(boolean forSale) {
		this.forSale = forSale; 
	}

	public int getMpg() {
		return mpg;
	}

	public void setMpg(int mpg) {
		this.mpg = mpg;
	}

	public int getHwy() {
		return hwy;
	}

	public void setHwy(int hwy) {
		this.hwy = hwy;
	}

	public String getVin() {
		return vin;
	}

	public void setVIN(String vin) {
		this.vin = vin;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {		
			
			this.price = price;
		
	}
	public int getMiles() {
		return miles;
	}
	public void setMiles(int miles) {
		this.miles = miles;
	}
	public int getDaysInLot() {
		return daysInLot;
		
	
	}
	public void setDaysInLot(int daysInLot) {
		this.daysInLot = daysInLot;
	}

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}
	

	public Date getDatePurchased() {
		return datePurchased;
	}

	public void setDatePurchased(Date datePurchased) {
		this.datePurchased = datePurchased;
	}

	@Override
	public String toString() {
		return  make + "," + model +"," +  vin 
				+"," +  color +"," +  price +"," +  year
				+"," +  mpg +"," +  hwy +"," +  used +"," +  miles + "," + dateAdded + "," + forSale + "--";
	}
	
	
	public static String getLotAsString(ArrayList<Car> lot) {
		String content = "";
		
		for(Car var : lot) {
			
			
			if(var.isForSale() == true) {
			content += var.toString();
			}
		}
		
		
		
		return content;
	}
	
	
	// When the a car is bought
	public static void carSold(Car carBought, Buyer buyer) {
		
		//ArrayList<Car> buyerLot = (ArrayList<Car>)session.getAttribute("lot");
		
		
		// read the full file to generate the full lot in an array
		String content = "";
		try {
			
			File carFile = new File(path + "Car_Lot.txt");
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
			//System.out.println(carParams[4].toString());
			System.out.println(carParams[9].toString());
			
			double newPrice = Double.parseDouble(carParams[4]);
			
			
			int newYear = Integer.parseInt(carParams[5]);
			int newMpg = Integer.parseInt(carParams[6]);
			int newHwy = Integer.parseInt(carParams[7]);
			boolean newUsed = Boolean.parseBoolean(carParams[8]);
			int newMiles = Integer.parseInt(carParams[9]);
			//String dateAdded = Integer.parseInt(carParams[10]);
			
			
			Car newCar = new Car(carParams[0],carParams[1],carParams[2],
					carParams[3],newPrice,newYear,newMpg,
					newHwy,newUsed,newMiles,carParams[10]);
			
			
	
			lot.add(newCar);
			
			
		
		}
		
		
		// compare the car with the full lot and change the car
		// with matching vins
		
		for(Car car : lot) {
			
			if(car.getVin().equals(carBought.getVin())) {
				System.out.println("*****" + buyer +  "*******");
				car.setForSale(false);
				car.setBuyer(buyer);
			}
			
			
		} 
		
		carBought.setBuyer(buyer);
		
		
		// rewrite the file without the sold car
	
		String fileName = path + "Car_Lot.txt" ;
		try {
			FileWriter fstream = new FileWriter(fileName);
			try(BufferedWriter bw = new BufferedWriter(fstream)){
				bw.write(getLotAsString(lot));
				bw.close();
			}
		}
		catch(IOException e){
			System.out.println("error writing to file");
		}
		
		
		// add sold car to a the transactions file
		
		try {
			File lotFile = new File("Car_Transactions.txt");
			if(lotFile.createNewFile()) {
				System.out.println("file created");
			} 
			
		} catch (IOException e) {
			System.out.println("An error occurred");
		}
	
		try {
			final String path = "/Users/richardnava/Documents/dealership-files/";
			String fileName2 = path + "Car_Transactions.txt";
			FileWriter fstream = new FileWriter(fileName2, true);
			try(BufferedWriter bw = new BufferedWriter(fstream)){	
			bw.write(carBought.toPurchaseFormat());
			bw.close();
			
			}
		}
		catch(IOException e) {
			System.out.println("Error writing to file");
		}
		
	
	}
	
	public String toPurchaseFormat() {
		
		return make + "," + model + "," + vin + "," + year + "," + color + ","+ price + "," + datePurchased + "," + buyer + "--";
	}

	
	
	// date added to lot from String to Date
	public Date lotDate(String dateAdded) throws ParseException {
		
		
		Date purchaseDate = new SimpleDateFormat("MM/dd/yyyy").parse(dateAdded);
		
		return purchaseDate;
		
	}
	
	
	// date purchased from lot from String to Date
	public Date purchaseDate(String sellDate) throws ParseException {
		
		
		Date dateSold = new SimpleDateFormat("MM/dd/yyyy").parse(sellDate);
		return dateSold;
	}
	
	public int calcDaysInLot(Date lotDate) {
		
		Date today = Calendar.getInstance().getTime(); 
		int daysInLot = (int) ChronoUnit.DAYS.between(lotDate.toInstant(), today.toInstant());
		
		return daysInLot;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}
	
	public String getDateAddedInString() {
		return dateAddedInString;
	}

	public void setDateAddedInString(String dateInString) {
		this.dateAddedInString = dateInString;
	}
	
	public String getDateSoldInString() {
		return dateSoldInString;
	}

	public void setDateSoldInString(String dateSoldInString) {
		this.dateSoldInString = dateSoldInString;
	}
	
	public String reportFormat() {
		
		return "Customer: " + buyer + "Vehicle: " +year+ " " + make + " " + model + " " + color + " " + "\n" 
		+ "VIN: " + vin + " " + "Price: " + price + "\n" 
		+ "Purchased on: " + dateSoldInString + "\n" + "----" + "\n";
	}
	
	
}
	


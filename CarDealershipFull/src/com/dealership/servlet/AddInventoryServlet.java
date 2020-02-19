package com.dealership.servlet;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.Car;
import com.user.Inventory;

/**
 * Servlet implementation class AddInventoryServlet
 */
@WebServlet("/AddInventoryServlet")
public class AddInventoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddInventoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		
		ArrayList<Car> lot = (ArrayList<Car>)session.getAttribute("lot");
	
		if(lot == null) {
			
			lot = new ArrayList<>();
		}
		

		
		Car newCar = new Car();
		
		//String imgLink = request.getParameter("img");
		//File imgReal = new File(request.getParameter("img"));
		
		newCar.setMake(request.getParameter("make"));
		newCar.setModel(request.getParameter("model"));
		newCar.setColor(request.getParameter("color"));
		newCar.setVIN(request.getParameter("vin"));
		newCar.setPrice(Double.parseDouble(request.getParameter("price")));
		newCar.setYear(Integer.parseInt(request.getParameter("year")));
		newCar.setHwy(Integer.parseInt(request.getParameter("hwy")));
		newCar.setMpg(Integer.parseInt(request.getParameter("mpg")));
		//newCar.setDaysInLot(Integer.parseInt(request.getParameter("daysInLot")));
		
		String dateAdded = (request.getParameter("dateAdded"));
		try {
			newCar.setDateAdded(newCar.lotDate(dateAdded));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//newCar.setDateAddedInString(request.getParameter("dateAdded"));
		
		//String dateInString = request.getParameter("dateAdded");
		//newCar.setDateInString(dateInString);
		
		
		
		newCar.setMiles(Integer.parseInt(request.getParameter("miles")));
		//newCar.setMiles(Integer.parseInt(request.getParameter("miles")));
		//newCar.setImage(imgReal);
	
		if(request.getParameter("nou").equals("new")) {
			
			newCar.setUsed(false);
		}
		else {
			
			newCar.setUsed(true);
		}
		
		Inventory.lotPriceCheck(newCar);
		
		lot.add(newCar);
		
		

		try {
			File lotFile = new File("Car_Lot.txt");
			if(lotFile.createNewFile()) {
				System.out.println("file created");
			} 
			
		} catch (IOException e) {
			System.out.println("An error occurred");
		}
		
		
		
		
		String list = Arrays.toString(lot.toArray()).replace("[", "").replace("]", "");

		
		try {
			final String path = "/Users/richardnava/Documents/dealership-files/";
			String fileName = path + "Car_Lot.txt";
			FileWriter fstream = new FileWriter(fileName, true);
			try(BufferedWriter bw = new BufferedWriter(fstream)){	
			bw.write(newCar.toString());
			bw.close();
			
			}
		}
		catch(IOException e) {
			System.out.println("Error writing to file");
		}
		
		session.setAttribute("lot", lot);
				

//
//		
//		ArrayList<Car> lot = Inventory.addToLot(newCar, priorLot);
		
//		session.setAttribute("lot", lot);

		
		RequestDispatcher rs = request.getRequestDispatcher("AdditionConfirm.jsp");
		rs.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	
		doGet(request, response);
	}

}

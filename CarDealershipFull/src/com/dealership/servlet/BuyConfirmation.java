package com.dealership.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.Buyer;
import com.user.BuyerAddress;
import com.user.Car;

/**
 * Servlet implementation class BuyConfirmation
 */
@WebServlet("/BuyConfirmation")
public class BuyConfirmation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyConfirmation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		ArrayList<Car> lot = (ArrayList<Car>)session.getAttribute("lot");
	
		
		String fname = request.getParameter("first");
		String lname = request.getParameter("last");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String street = request.getParameter("street");
		String zip = request.getParameter("zip");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String day = request.getParameter("day");
		
		BuyerAddress address = new BuyerAddress(street, city, state, zip);
		Buyer profile = new Buyer(fname, lname, email, phone, address);
		
		System.out.println(profile.toString());
		try {
			lot.get(0).setDatePurchased(lot.get(0).purchaseDate(day));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Car.carSold(lot.get(0),profile);
		
		session.setAttribute("lot", lot);
		
		RequestDispatcher rs = request.getRequestDispatcher("Homepage.jsp");
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

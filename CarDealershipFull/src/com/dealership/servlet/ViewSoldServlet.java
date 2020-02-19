package com.dealership.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.Car;
import com.user.Search;

/**
 * Servlet implementation class ViewSoldServlet
 */
@WebServlet("/ViewSoldServlet")
public class ViewSoldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewSoldServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		final String path = "/Users/richardnava/Documents/dealership-files/Car_Lot.txt";
		Search search = new Search();
		
		// define the real array and the arrays of stuff for sale
		ArrayList<Car> lot = new ArrayList<Car>();
		ArrayList<Car> toRemove = new ArrayList<Car>();
		
		
		// generate full lot
		lot = search.getSoldInventory();
		
		// if a car in the lot is for sale, add it to the 
		// removal array
		/* for(Car var : lot) {
			
			if(var.isForSale() == true) {
				toRemove.add(var);
			}
		} */
		
		// remove the contents of the removal lot from the real lot
		// lot.removeAll(toRemove);
		
		// define session
		
		session.setAttribute("lot", lot);
		RequestDispatcher rs = request.getRequestDispatcher("SoldCars.jsp");
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

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
 * Servlet implementation class HomepageRefreshServlet
 */
@WebServlet("/HomepageRefreshServlet")
public class HomepageRefreshServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomepageRefreshServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		final String path = "/Users/richardnava/Documents/dealership-files/Car_Lot.txt";
		
		//System.out.println("In search servlet");
		ArrayList<Car> lot = new ArrayList<Car>();
		
		Search search = new Search();
		
		try {
		lot = search.getInventory();
		}
		catch(NullPointerException e) {
			System.out.println("No Cars");
		}
		
		
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

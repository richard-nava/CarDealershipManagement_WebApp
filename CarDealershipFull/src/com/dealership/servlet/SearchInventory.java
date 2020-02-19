package com.dealership.servlet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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
 * Servlet implementation class SearchInventory
 */
@WebServlet("/SearchInventory")
public class SearchInventory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchInventory() {
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
		
		lot = search.getInventory();
		
		/*
		 * for(Car va:lot) { System.out.println(va.getVin()); }
		 */
		
		String searchType = request.getParameter("searchParam");
		
		//added
		String keyVal = request.getParameter("keyval");
		
		lot = search.searchBy(searchType, keyVal, lot);
		
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

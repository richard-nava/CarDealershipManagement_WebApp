<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page import= "java.util.ArrayList" %>
    <%@page import="com.user.Car" %>
<% Car newCar = (Car) session.getAttribute("newCar"); %>
<% ArrayList<Car> lot = (ArrayList<Car>)session.getAttribute("lot"); %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sold Cars</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" 
		integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="Homepage.jsp">
  	<img src="https://dewey.tailorbrands.com/production/brand_version_mockup_image/596/2637872596_c0b288f3-3894-44cd-b925-8b2e5fe5d807.png?cb=1581305799">
  </a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>


  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <a class="nav-link" href="Homepage.jsp">Home <span class="sr-only"></span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">About</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Inventory
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="AddToInventory.jsp">Add to Inventory</a>
          <a class="dropdown-item" href="SoldCars.jsp">Sold Cars</a>
          
          
          <a class="dropdown-item" type="submit" href="PrintSalesReportServlet.java">Sales Report</a>
          
          
        </div>
      </li>
      <li class="nav-item">
        <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true"></a>
      </li>
    </ul>
    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
</nav>

<div class="container">
  <div class="row">
    <div class="col-sm">
      <a type="button" class="btn btn-primary" href="AddToInventory.jsp">Add Car to Inventory</a>
    </div>
    <div class="col-sm">
      <a type="button" class="btn btn-primary" href="PrintSalesReportServlet">Print Sales Report</a>
    </div>
    <div class="col-sm">
  
    </div>
  </div>
</div>
<br>

<div class="container">
	<c:if test="${lot != null }">
	<table class="table">
  <thead>
    <tr>
      <th scope="col">Make</th>
      <th scope="col">Model</th>
      <th scope="col">Year</th>
       <th scope="col">Used?</th>
       <th scope="col">Date Purchased</th>
       <th scope="col">VIN</th>
       <th scope="col">Buyer</th>
       
    </tr>
    <c:forEach var="car" items="${lot}">
    	
    
    	<tr>
    		<td> <c:out value="${car.make}"/> </td>
    		<td> <c:out value="${car.model}"/> </td>
    		<td> <c:out value="${car.year}"/> </td>
    		<td> <c:out value="${car.used}"/> </td>
    		<td> <c:out value="${car.dateSoldInString}"/> </td>
    		<td> <c:out value="${car.vin}"/> </td>
    		<td> <c:out value="${car.buyer}"/> </td>
    	</tr>
    	
    </c:forEach>
  </thead>
 
</table>
</c:if>
	</div>
	
	



</body>
</html>
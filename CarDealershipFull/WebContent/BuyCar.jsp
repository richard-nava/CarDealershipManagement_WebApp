<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page import= "java.util.ArrayList" %>
    <%@page import="com.user.Car" %>
    <%@page import="com.user.Search" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Royal Rick's</title>

<link rel="stylesheet" type="text/css" href="styles/carstyles.css">
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
      <li class="nav-item active">
        <a class="nav-link" href="Homepage.jsp">Home <span class="sr-only">(current)</span></a>
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
          
          <a class="dropdown-item" href="#">Sales Report</a>
        </div>
      </li>
      <li class="nav-item">
        <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
      </li>
    </ul>
    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
</nav>

<form action="BuyConfirmation" class="container" method="post">
<h3>Enter Customer Info</h3>
	
	<div class="form-group">
		<label for="first">First Name</label>
		<input type="text" class="form-control" name="first" id="first" placeholder="Ex: Richard">
		<span class="form-group"><label for="last">Last Name</label></span>
<input type="text" class="form-control" name="last" id="last" placeholder="Ex: Nava">
	</div>
	
	<div class="form-group">
<label for="day">Date of Purchase</label>
<input type="text" class="form-control" name="day" id="day" placeholder="Ex: 02/19/2020">
</div>
<div class="form-group">
<label for="email">email</label>
<input type="text" class="form-control" name="email" id="email" placeholder="Ex: richard.nava@gmail.com">
</div>
<div class="form-group">
<label for="phone">Phone Number</label>
<input type="text" class="form-control" name="phone" id="phone" placeholder="Ex: 773-301-6222">
</div>
<div class="form-group">
<label for="street">Street Address</label>
<input type="text" class="form-control" name="street" id="street" placeholder="Ex: 123 Fake St">
</div>
<div class="form-group">
<label for="city">City</label>
<input type="text" class="form-control" name="city" id="city" placeholder="Ex: Chicago">

<span class="form-group"><label for="state">State</label></span>
<input type="text" class="form-control" name="state" id="state" placeholder="Ex: IL">

<span class="form-group"><label for="zip">Zip</label></span>
<input type="text" class="form-control" name="zip" id="zip" placeholder="Ex: 60659">


</div>

<button type="submit" value="Upload" name="upload" id="upload" class="btn btn-default">Submit</button>

</form>

</body>
</html>
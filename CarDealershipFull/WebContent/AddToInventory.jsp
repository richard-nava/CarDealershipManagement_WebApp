<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>


<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" 
		integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<title>Add Car to Inventory</title>
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
      <li class="nav-item dropdown active">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Inventory<span class="sr-only">(current)</span>
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


<h3>Add a New Car to Inventory!</h3>
<img alt="New Car!" src="https://media.giphy.com/media/3oriOfGpa52x3J4Z68/giphy.gif">

<form action="AddInventoryServlet" class="container" method="post">
	
	<div class="form-group">
		<label for="make">Make</label>
		<input type="text" class="form-control" name="make" id="make" placeholder="Ex: Honda">
	</div>
<div class="form-group">
	<label for="model">Model</label>
<input type="text" class="form-control" name="model" id="model" placeholder="Ex: Civic">
</div>
<div class="form-group">
<label for="year">Year</label>
<input type="text" class="form-control" name="year" id="year" placeholder="Ex: 2020">
</div>
<div class="form-group">
<label for="color">Color</label>
<input type="text" class="form-control" name="color" id="color" placeholder="Ex: Silver">
</div>
<div class="form-group">
<label for="vin">VIN #</label>
<input type="text" class="form-control" name="vin" id="vin" placeholder="Enter VIN# Here">
</div>
<div class="form-group">
<label for="price">Price</label>
<input type="text" class="form-control" name="price" id="price" placeholder="8999">
</div>
<div class="form-group">
<label for="miles">Miles On Car</label>
<input type="text" class="form-control" name="miles" id="miles" placeholder="20000">
</div>
<div class="form-check">
  <input class="form-check-input" type="radio" name="nou" id="exampleRadios1" value="new" checked>
  <label class="form-check-label" for="exampleRadios1">
   New
  </label>
</div>
<div class="form-check">
  <input class="form-check-input" type="radio" name="nou" id="exampleRadios2" value="used">
  <label class="form-check-label" for="exampleRadios2">
    Used
  </label>
</div>

<!-- DAYS IN THE LOT -->
<!--  
<div class="form-group">
<label for="daysInLot">Days In Lot</label>
<input type="text" class="form-control" name="daysInLot" id="daysInLot" placeholder="Ex: 13">
</div>
-->

<div class="form-group">
<label for="dateAdded">Date Added to Lot</label>
<input type="text" class="form-control" name="dateAdded" id="dateAdded" placeholder="Ex: 06/01/1995">
</div>


<br>
<span class="form-group"><label for="hwy">Highway Milage</label> 
<input type="text" class="form-control" name="hwy" id="hwy" placeholder="Highway MPG">
</span>
<span class="form-group"><label for="mpg">MPG</label> 
<input type="text" class="form-control" name="mpg" id="mpg" placeholder="MPG">
</span>


<button type="submit" value="Upload" name="upload" id="upload" class="btn btn-default">Submit</button>

</form>

</body>
</html>
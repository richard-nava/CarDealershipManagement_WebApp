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
        <a class="nav-link" href="HomepageRefreshServlet">Home <span class="sr-only">(current)</span></a>
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
          <a class="dropdown-item" href="ViewSoldServlet">Sold Cars</a>
          <a class="dropdown-item" href="#">Sales Report</a>
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
 <form action="SearchInventory" method="get">
  <div class="row">
    <div class="col">
     <div class="input-group mb-3">
  <div class="input-group-prepend">
    <label class="input-group-text" for="inputGroupSelect01">Search By</label>
  </div>
</div>
 
</div>
  
    <div class="col searchOps">
      <select class="custom-select" name="keyval" id="inputGroupSelect01">
    <option selected>Choose Search option</option>
    <option value="make">Make</option>
    <option value="year">Year</option>
    <option value="model">Model</option>
    <option value="color">Color</option>
    
  </select>
    </div>
    <div class="col">
     <input type="text" class="form-control" name="searchParam" placeholder="Ex: Civic">
    </div>
     <div class="col">
     <button type="submit" class="btn btn-primary">Search</button>
    </div>
      </div>
      </form>
      
      <div class="col">
      <div class="container" name="theLot">
	<c:if test="${lot==null}">
		<div class="warning">
		
		<p>Welcome to the Royal Rick's Inventory Management WebApp!</p>
		</div>
	</c:if>
	<c:if test="${lot != null }">
	<table class="table">
  <thead>
    
   
    <c:forEach var="car" items="${lot}">
    
   
    <div class="card mb-3" id="${car.vin}" style="max-width: 700px;">
  <div class="row no-gutters">
    <div class="col-md-4">
      <img src="https://i.insider.com/5e14913f954bda05c2610bd3?width=1100&format=jpeg&auto=webp" class="card-img" alt="...">
    </div>
    <div class="col-md-8">
      <div class="card-body">
        <h5 class="card-title">Card title</h5>
        <p class="card-text">
       	 <c:out value="${car.make}"/>
       	 <c:out value="${car.model}"/>
       	 <c:out value="${car.year}"/>
       	 <br>
       	 <c:out value="${car.color}"/>
       	  <c:out value="${car.used}"/>
       	 <c:out value="${car.hwy} / ${car.mpg}"/>
       	 <c:out value="${car.dateAddedInString}"/>
       </p>
       <form action="CarDescriptionServlet" >
       <button type="submit" name="vin" value="${car.vin}">Closer Look</button>
       </form>	
       <form action="GoToBuyCarServlet" >
       <button type="submit" name="vin" value="${car.vin}">Purchase</button>
       </form>	
        <p class="card-text"><small class="text-muted">Buy this</small></p>
      </div>
    </div>
  </div>
</div> 
    	
    </c:forEach>
  </thead>
 
</table>
</c:if>
	
	
	
	</div>
	
      
      </div>
  </div>



<!-- <div class="container-fluid">
<div class="row">
    
    <form action="SearchInventory" method="get">
    <div class="col-sm-5">
    
      <div class="gensearch" >
      <div class="input-group-prepend">
       <div class="input-group mb-3" style="max-width: 2000px">
  <input type="text" class="form-control" name="searchParam" placeholder="Ex: Civic">
	 
</div>
      <div class="input-group mb-3">
  <div class="input-group-prepend">
    <label class="input-group-text" for="inputGroupSelect01">Search By</label>
  </div>
  <select class="custom-select" name="keyval" id="inputGroupSelect01">
    <option selected>Choose Search option</option>
    <option value="make">Make</option>
    <option value="year">Year</option>
    <option value="model">Model</option>
    <option value="color">Color</option>
    
  </select>
</div>
 
</div>
	<button type="submit" class="btn btn-primary">Search</button>

</div> -->


  <div class="col-sm-6 col-md-5 col-lg-3">
	<%-- <div class="container" name="theLot">
	<c:if test="${lot==null}">
		<div class="warning">
		
		<p>Welcome to the Royal Rick's Inventory Management WebApp!</p>
		</div>
	</c:if>
	<c:if test="${lot != null }">
	<table class="table">
  <thead>
    
   
    <c:forEach var="car" items="${lot}">
    
   
    <div class="card mb-3" id="${car.vin}" style="max-width: 1000px;">
  <div class="row no-gutters">
    <div class="col-md-4">
      <img src="https://i.insider.com/5e14913f954bda05c2610bd3?width=1100&format=jpeg&auto=webp" class="card-img" alt="...">
    </div>
    <div class="col-md-8">
      <div class="card-body">
        <h5 class="card-title">Card title</h5>
        <p class="card-text">
       	 <c:out value="${car.make}"/>
       	 <c:out value="${car.model}"/>
       	 <c:out value="${car.year}"/>
       	 <br>
       	 <c:out value="${car.color}"/>
       	  <c:out value="${car.used}"/>
       	 <c:out value="${car.hwy} / ${car.mpg}"/>
       </p>
       <form action="CarDescriptionServlet" >
       <button type="submit" name="vin" value="${car.vin}">BUY!</button>
       </form>	
        <p class="card-text"><small class="text-muted">Buy this</small></p>
      </div>
    </div>
  </div>
</div> 
    	
    </c:forEach>
  </thead>
 
</table>
</c:if>
	
	
	
	</div>
	 --%>
	 

  </div>


  <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

</body>
</html>
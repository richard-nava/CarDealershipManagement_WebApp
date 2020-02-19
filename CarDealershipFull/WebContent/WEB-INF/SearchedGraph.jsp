<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page import= "java.util.ArrayList" %>
    <%@page import="com.user.Car" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="styles/carstyles.css">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" 
	  integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>

  <div class="col-sm-7 col-md-5 col-lg-3">
	<div class="container" name="theLot">
	<c:if test="${lot==null}">
		<div class="warning">
		
		<p>You have no cars in your lot!
		</div>
	</c:if>
	<c:if test="${lot != null }">
	<table class="table">
  <thead>
    <tr>
    	<th scope="col">Photo</th>
      <th scope="col">Make</th>
      <th scope="col">Model</th>
      <th scope="col">Year</th>
  		<th scope="col">HWY/MPG</th>
      <th scope="col">Color</th>
       <th scope="col">Used?</th>
       <th scope="col">VIN</th>
       <th scope="col">Price</th>
        <th scope="col">Description</th>
       
    </tr>
    <c:forEach var="car" items="${lot}">
    	<tr>
    		<td> <c:out value="${car.image}"/> </td>
    		<td> <c:out value="${car.make}"/> </td>
    		<td> <c:out value="${car.model}"/> </td>
    		<td> <c:out value="${car.year}"/> </td>
    		<td> <c:out value="${car.hwy} / ${car.mpg}"/> </td>
    		<td> <c:out value="${car.color}"/> </td>
    		<td> <c:out value="${car.used}"/> </td>
    		<td> <c:out value="${car.vin}"/> </td>
    		<td> <c:out value="${car.price}"/> </td>
    		<td> <c:out value="${car.description}"/> </td>
    		
    	</tr>
    </c:forEach>
  </thead>
 
</table>
</c:if>
	
	
	
	</div>
	
	 

  </div>

</body>
</html>
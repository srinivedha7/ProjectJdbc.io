<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA_Compatible" content="ie=edge">
<link rel="stylesheet" href="styles/style.css">
<title>Menu Item List Customer</title>
</head>
<body>
	<div class="topnav">
		<div class="home">truYum</div>
		<img src="C:\Users\833385\Documents\tru Yum\truyum-logo-light.png">
		<a href="ShowCart">Cart</a> <a href="ShowMenuItemListCustomer">Menu</a>
	</div>
	<div class="head">
		<h3>Menu Items</h3>
		<c:if test="${addCartStatus}">
			<div class="status">Item Added to Cart Successfully</div>
		</c:if>
		<table cellpadding="15px">
			<tr>
				<th>Name</th>
				<th>Free Delivery</th>
				<th>Price</th>
				<th>Category</th>
				<th>Action</th>
			</tr>
			<c:forEach var="menuItemList" items="${menuItemList}">
				<tr>
					<td>${menuItemList.name}</td>
					<td><c:choose>
							<c:when test="${menuItemList.freeDelivery eq'true'}">Yes</c:when>
							<c:otherwise>No</c:otherwise>
						</c:choose></td>
					<td><fmt:formatDate type="date" pattern="dd/MM/yyyy"
							value="${menuItemList.dateOfLaunch}"></fmt:formatDate></td>
					<td>${menuItemList.category}</td>
					<td><a href="AddToCart?menuItemId=${menuItemList.id}">Add
							to cart</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
<div class="footer">
	<h4>Copyright @ 2019</h4>
</div>
</html>
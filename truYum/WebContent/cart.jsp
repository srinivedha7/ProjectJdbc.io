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
<script src="script.js"></script>
<title>Cart</title>
</head>
<body>
	<div class="topnav">
		<div class="home">truYum</div>
		<img src="C:\Users\833385\Documents\tru Yum\truyum-logo-light.png">
		<a href="ShowCart">Cart</a> <a href="ShowMenuItemListCustomer">Menu</a>
	</div>
	<div class="head">
		<h4>Cart</h4>
	</div>
	<span class="status" id="span"></span>
	<c:if test="${deletecartstatus}">
		<div class="status">Item removed from cart successfully</div>
	</c:if>
	<table>
		<tr>
			<th>Name</th>
			<th>Free Delivery</th>
			<th>Price</th>
			<th></th>
		</tr>
		<c:forEach items="${cart.menuItemList}" var="menuItem">
			<tr>
				<td>${menuItem.name}</td>
				<td><c:choose>
						<c:when test="${menuItem.freeDelivery eq 'true'}">Yes</c:when>
						<c:when test="${menuItem.freeDelivery eq 'false'}">No</c:when>
					</c:choose></td>
				<td><fmt:setLocale value="en_IN" /> <fmt:formatNumber
						type="currency" value="${menuItem.price}" /></td>
				<td><a class="fcolor" href="RemoveCartItem?id=${menuItem.id}">Delete</a></td>
		</c:forEach>
		<tr>
			<td></td>
			<td class="total">Total</td>
			<td class="total"><fmt:setLocale value="en_IN" /> <fmt:formatNumber
					type="currency" value="${cart.total}" /></td>
			<td></td>
		</tr>
	</table>
	<div class="footer">
		<h4>Copyright @ 2019</h4>
	</div>
</body>
</html>
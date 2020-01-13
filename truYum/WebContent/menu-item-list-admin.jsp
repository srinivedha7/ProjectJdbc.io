<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="js/script.js"></script>
<link rel="stylesheet" href="styles/style.css">
<title>Menu Item List Admin</title>
</head>
<body>
	<div class="topnav">
		<div class="home">truYum</div>
		<img src="C:\Users\833385\Documents\tru Yum\truyum-logo-light.png">
		<a href="ShowMenuItemListAdmin">Menu</a>
	</div>
	<div class="head">
		<h3>Menu Items</h3>
	</div>
	<table cellspacing="0px" cellpadding="15px">
		<tr>
			<th>Name</th>
			<th class="currency">Price</th>
			<th>Active</th>
			<th>Date of Launch</th>
			<th>Category</th>
			<th>Free Delivery</th>
			<th>Action</th>
		</tr>
		<c:forEach var="menuItemList" items="${menuItemList}">
			<tr>
				<td>${menuItemList.name}</td>

				<td class="currency"><fmt:setLocale value="en_IN" /> <fmt:formatNumber
						type="currency" value="${menuItemList.price}" /></td>
				<td><c:choose>
						<c:when test="${menuItemList.active eq'true'}">Yes</c:when>
						<c:otherwise>No</c:otherwise>
					</c:choose></td>
				<td><fmt:formatDate type="date" pattern="dd/MM/yyyy"
						value="${menuItemList.dateOfLaunch}"></fmt:formatDate></td>
				<td>${menuItemList.category}</td>
				<td><c:choose>
						<c:when test="${menuItemList.freeDelivery eq'true'}">Yes</c:when>
						<c:otherwise>No</c:otherwise>
					</c:choose></td>
				<td><a href="ShowEditMenuItem?id=${menuItemList.id}">Edit</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
<div class="footer">
	<h4>Copyright @ 2019</h4>
</div>
</html>
<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA_Compatible" content="ie=edge">
<title>Edit Menu Item</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="styles/style.css">
<script src="js/script.js"></script>
<title>Insert title here</title>
</head>
<body>
<body>
	<div class="topnav">
		<div class="home">truYum</div>
		<img src="C:\Users\833385\Documents\tru Yum\truyum-logo-light.png">
		<a href="ShowMenuItemListAdmin">Menu</a>
	</div>
	<div class="head">
		<h3>Edit Menu Items</h3>
	</div>
	<div class="body-content-colour"></div>
	<form action="EditMenuItem" onsubmit="return validateMenuItemForm()"
		name="menuItemForm" method="post">
		<div class="form-field-spacing">
			<label for="name">Name</label>
			<div>
				<input type="text" class="text-box" name="name" 
					value="${menuItem.name}">
			</div>
		</div>
		<div class="form-field-spacing">
			<label for="price">Price(Rs.)</label>
			<div>
				<input type="text" class="text-boxp" name="price"
					value='${menuItem.price}'>
			</div>
		</div>
		<div class="form-field-spacing">
			<label for="active">Active</label>
			<div>
				Yes<input type="radio" class="radiobuttons" name="active"
					value="yes"
					<c:if test="${menuItem.active eq 'true'}" >checked </c:if>>
				No<input type="radio" class="radiobuttons" name="active" value="no"
					<c:if test="${menuItem.active eq 'false'}" >checked</c:if>>
			</div>
		</div>
		<div class="form-field-spacing">
			<label for="dateOfLaunch">Date of Launch</label>
			<div>
				<input type="text" class="checkbox" name="dateOfLaunch"
					value="<fmt:formatDate type='date' pattern='dd/MM/yyyy' value='${menuItem.dateOfLaunch}'/>">
			</div>
		</div>
		<div class="form-field-spacing">
			<label for="category">Category</label>
			<div>
				<select name="category" class="dropdown">
					<option value="${menuItem.category}">${menuItem.category}</option>
					<option value="Starters">Starters</option>
					<option value="Maincourse">Main Course</option>
					<option value="Dessert">Dessert</option>
					<option value="Drinks">Drinks</option>
				</select>
			</div>
		</div>
		<div class="form-field-spacing">
			<div>
				<label for="freeDelivery">Free Delivery</label> <input
					type="checkbox" name="freeDelivery"
					<c:if test="${menuItem.freeDelivery eq 'true'}" >checked </c:if>>
			</div>
		</div>
		<div>
			<input type="hidden" name="id" value="${menuItem.id}">
		</div>
		<div class="form-field-spacing">
			<input type="submit" class="button success-button" value="Save">
		</div>
	</form>
	<div class="footer">
		<h4>Copyright @ 2019</h4>
	</div>
</body>
</html>
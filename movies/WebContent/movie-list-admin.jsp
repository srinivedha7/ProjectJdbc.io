<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="styles/style.css">
<script src="js/script.js"></script>
<title>Movie List Admin</title>
</head>
<body>
	<div class="topnav">
		<div class="home">Movie Crusier</div>
		<img
			src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSvrorCdK6gftsE_bC7VRg4DvR6obHwLniP_7jG0Xl3IUSHaTy37A&s">
		<a href="ShowMovieListAdmin">Movies</a>
	</div>
	<div class="head">
		<h3>Movies</h3>
	</div>
	<table cellspacing="0px" cellpadding="15px">
		<tr>
			<th>Title</th>
			<th>Box Office</th>
			<th>Active</th>
			<th>Date of Launch</th>
			<th>Genre</th>
			<th>Has Teaser</th>
			<th>Action</th>
		</tr>
		<c:forEach var="moviesList" items="${moviesList}">
			<tr>
				<td>${moviesList.title}</td>
				<td><fmt:setLocale value="en_US" /> <fmt:formatNumber
						type="currency" value="${moviesList.gross}" /></td>
				<td><c:choose>
						<c:when test="${moviesList.active eq'true'}">Yes</c:when>
						<c:otherwise>No</c:otherwise>
					</c:choose></td>
				<td><fmt:formatDate type="date" pattern="dd/MM/yyyy"
						value="${moviesList.dateOfLaunch}"></fmt:formatDate></td>
				<td>${moviesList.genre}</td>
				<td><c:choose>
						<c:when test="${moviesList.teaser eq'true'}">Yes</c:when>
						<c:otherwise>No</c:otherwise>
					</c:choose></td>
				<td><a href="ShowEditMovie?id=${moviesList.id}">Edit</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
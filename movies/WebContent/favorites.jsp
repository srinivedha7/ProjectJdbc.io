<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="styles/style.css">
<script src="js/script.js"></script>
<title>Favorites</title>
</head>
<body>
<body onload="addColumn()">

	<div class="topnav">
		<div class="home">Movie Cruiser</div>
		<img
			src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSvrorCdK6gftsE_bC7VRg4DvR6obHwLniP_7jG0Xl3IUSHaTy37A&s">
		<a href="ShowFavorites">Favorites</a> <a href="ShowMovieListCustomer">Movies</a>
	</div>
	<div class="head">
		<h3>Favorites</h3>
	</div>
	<c:if test="${deletefavoritesstatus}">
		<span class="notification" id="span"></span>
		<div class="status">Item removed from cart successfully</div>
	</c:if>
	<table id="table_id">
		<tr>
			<th>Title</th>
			<th>Box Office</th>
			<th>Genre</th>
		</tr>
		<c:forEach items="${favorites.movieList}" var="moviesList">
			<tr>
				<td>${moviesList.title}</td>
				<%-- <td><c:choose>
						<c:when test="${moviesList.teaser eq 'true'}">Yes</c:when>
						<c:when test="${moviesList.teaser eq 'false'}">No</c:when>
					</c:choose></td> --%>
				<td><fmt:setLocale value="en_US" /> <fmt:formatNumber
						type="currency" value="${moviesList.gross}" /></td>
				<td>${moviesList.genre}</td>
				<td><a class="fcolor"
					href="RemoveFavorites?id=${moviesList.id}">Delete</a></td>
		</c:forEach>
		<tr>

			<td><b>No. of favorites:</b></td>
			<td><b>${favorites.noOfFavorites}</b></td>
		</tr>
	</table>
	<div class="footer">
		<h4>Copyright @ 2019</h4>
	</div>
</body>
</html>
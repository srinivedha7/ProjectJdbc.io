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
<title>Edit Movie</title>
</head>
<body>
	<div class="topnav">
		<div class="home">Movie Crusier</div>
		<img
			src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSvrorCdK6gftsE_bC7VRg4DvR6obHwLniP_7jG0Xl3IUSHaTy37A&s">
		<a href="ShowMovieListAdmin">Movies</a>
	</div>
	<div class="head">
		<h3>Edit Movie</h3>
	</div>
	<form action="EditMovie" onsubmit="return validateMoviesForm()"
		name="moviesForm" method="post">
		<div class="form-field-spacing">
			<label for="title">Title</label> <input type="text" class="text-box"
				name="title" value="${movies.title}">
		</div>
		<div class="form-field-spacing">
			<label for="gross">Gross($)</label> <input type="text"
				class="textbox" name="gross" value="${movies.gross}">
		</div>
		<div class="form-field-spacing">
			<label for="active">Active</label> Yes<input type="radio"
				class="radiobuttons" name="active" value="yes"
				<c:if test = "${movies.active eq 'true'}"> checked </c:if>>
			No<input type="radio" class="radiobuttons" name="active" value="no"
				<c:if test = "${movies.active eq 'false'}"> checked </c:if>>
		</div>
		<div class="form-field-spacing">
			<label for="dateOfLaunch">Date of Launch</label>
			<div>
				<input type="text" class="checkbox" name="dateOfLaunch"
					value="<fmt:formatDate type='date' pattern='dd/MM/yyyy' value='${movies.dateOfLaunch}'/>">
			</div>
		</div>
		<div class="form-field-spacing">
			<label for="genre">Genre</label> <select name="genre"
				class="drop-down-list">
				<option value="${movies.genre}">${movies.genre}</option>
				<option value="Superhero">Superhero</option>
				<option value="scienceFiction">Science Fiction</option>
				<option value="Romance">Romance</option>
				<option value="Comedy">Comedy</option>
				<option value="Aduventure">Aduventure</option>
				<option value="Thriller">Thriller</option>
			</select>
		</div>
		<div class="form-field-spacing">
			<input type="checkbox" name="teaser" class="checkbox-teaser"
				<c:if test="${movies.teaser eq 'true'}"> checked </c:if>> <label
				for="teaser">Has Teaser</label>
		</div>
		<div>
			<input type="hidden" name="id" value="${movies.id}">
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
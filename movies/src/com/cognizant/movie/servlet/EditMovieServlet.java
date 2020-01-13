package com.cognizant.movie.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.movie.dao.MoviesDao;

import com.cognizant.movie.dao.MoviesDaoSqlImpl;
import com.cognizant.movie.model.Movies;


/**
 * Servlet implementation class EditMovieServlet
 */
@WebServlet("/EditMovie")
public class EditMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditMovieServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		String title = request.getParameter("title");
		long gross = Long.parseLong(request.getParameter("gross"));
		boolean active = request.getParameter("active").equals("yes");

		Date dateOfLaunch = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dateOfLaunch = sdf.parse(request.getParameter("dateOfLaunch"));
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		} 
 

		String genre = request.getParameter("genre");
		boolean teaser = request.getParameter("teaser") != null;
		Movies movies = new Movies(id, title, gross, active, dateOfLaunch, genre, teaser);
		MoviesDao moviesDao = new MoviesDaoSqlImpl();
		moviesDao.modifyMovies(movies);
		request.getRequestDispatcher("edit-movie-status.jsp").forward(request, response);
	}

}

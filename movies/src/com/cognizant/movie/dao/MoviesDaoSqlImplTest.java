package com.cognizant.movie.dao;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import com.cognizant.movie.model.Movies;
import com.cognizant.movie.util.DateUtil;

public class MoviesDaoSqlImplTest {

	public static void main(String[] args) {
		testGetMoviesListAdmin();
		testGetMoviesListCustomer();
		testModifyMovies();
		testGetMovies();
	}
	
	public static void testGetMoviesListAdmin() {
		
		List<Movies> moviesList =new MoviesDaoSqlImpl().getMoviesListAdmin();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("#,##,##,##,###");
		System.out.format("%15s%15s%15s%15s%15s%15s%20s", "ID", "TITLE", "GROSS", "ACTIVE", "DATE OF LAUNCH", "GENRE",
				"HAS TEASER");
		for (Movies movie : moviesList) {
			String teaser = movie.getTeaser() ? "Yes" : "No";
			String active =movie.getActive() ? "Yes" : "No";
			System.out.format("\n" + "%15s%20s%15s%10s%15s%20s%15s", movie.getId(),movie.getTitle(),df.format(movie.getGross()),active,sdf.format(movie.getDateOfLaunch()),movie.getGenre(),teaser);
		}
	}
	public static void testGetMoviesListCustomer() {
		System.out.println("CUSTOMER LIST");
		List<Movies> moviesListCustomer = new MoviesDaoSqlImpl().getMoviesListCustomer();
		DecimalFormat df = new DecimalFormat("#,##,##,##,###");
		System.out.format("%15s%20s%15s%15s%15s", "ID", "TITLE", "BOX OFFICE", "GENRE", "HAS TEASER");
		for (Movies movie : moviesListCustomer) {
			String teaser = movie.getTeaser() ? "Yes" : "No";
			System.out.format("\n" + "%15s%20s%20s%10s%15s", movie.getId(),movie.getTitle(),df.format(movie.getGross()),movie.getGenre(),teaser);
		}
	}
		public static void testModifyMovies() {
			Movies movies = new Movies(1L, "Coco", 1265787L, true, new DateUtil().convertToDate("15/03/2020"), "Dessert", true);
			new MoviesDaoSqlImpl().modifyMovies(movies);
			System.out.println("Modified item" + movies);

		}
		public static void testGetMovies() {
			long movieId = 2;
			System.out.println("GET MENU ITEM");
			Movies movies = new MoviesDaoSqlImpl().getMovies(movieId);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			DecimalFormat df = new DecimalFormat("#,##,##,##,###");
			System.out.format("%15s%15s%15s%15s%15s%15s%20s", "ID", "TITLE", "GROSS", "ACTIVE", "DATE OF LAUNCH", "GENRE",
					"HAS TEASER");
			String teaser = movies.getTeaser() ? "Yes" : "No";
			String active =movies.getActive() ? "Yes" : "No";
			System.out.format("\n" + "%15s%20s%15s%10s%15s%20s%15s", movies.getId(),movies.getTitle(),df.format(movies.getGross()),active,sdf.format(movies.getDateOfLaunch()),movies.getGenre(),teaser);
		}

}

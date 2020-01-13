package com.cognizant.movie.dao;

import java.util.List;

import com.cognizant.movie.model.Movies;

import com.cognizant.movie.util.DateUtil;

public class MoviesDaoCollectionImplTest {

	public static void testGetMoviesListAdmin() {
		System.out.println("Movie list for Admin");
		List<Movies> movieList = new MoviesDaoCollectionImpl().getMoviesListAdmin();
		for (Movies movies : movieList) {
			System.out.println(movies);
		}
	}

	public static void testGetMoviesListCustomer() {
		System.out.println("Item List for Customer");
		List<Movies> movieList = new MoviesDaoCollectionImpl().getMoviesListCustomer();
		for (Movies movies : movieList) {
			System.out.println(movies);
		}
	}

	public static void testModifyMovies() {
		Movies movies = new Movies(5L, "Frozen", 1000000L, true, new DateUtil().convertToDate("02/11/2022"),
				"Animation", true);
		MoviesDao moviesDao = new MoviesDaoCollectionImpl();
		moviesDao.modifyMovies(movies);
		System.out.println("Modified Movie List");
		testGetMoviesListAdmin();
		Movies modified_item = moviesDao.getMovies(movies.getId());
		System.out.println("Modified Movie detail\n" + modified_item);
	}

	public static void main(String[] args) {
		testGetMoviesListAdmin();
		testGetMoviesListCustomer();
		testModifyMovies();

	}
}
package com.cognizant.movie.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.movie.model.Movies;

import com.cognizant.movie.util.DateUtil;

public class MoviesDaoCollectionImpl implements MoviesDao {

	private static List<Movies> movieList;

	public MoviesDaoCollectionImpl() {
		if (movieList == null) {
			movieList = new ArrayList<Movies>();
			Movies itemOne = new Movies(1L, "Avatar", 2787965087L, true, new DateUtil().convertToDate("15/03/2017"),
					"Science Fiction", false);
			Movies itemTwo = new Movies(2L, "The Avengers", 1518812L, true, new DateUtil().convertToDate("23/12/2017"),
					"Superhero", true);
			Movies itemThree = new Movies(3L, "Titanic", 2187463944L, true, new DateUtil().convertToDate("21/08/2020"),
					"Science Fiction", true);
			Movies itemFour = new Movies(4L, "Jurassic World", 1671713208L, false,
					new DateUtil().convertToDate("12/12/2019"), "Science Fiction", true);
			Movies itemFive = new Movies(5L, "Avengers:End Game", 2750760348L, false,
					new DateUtil().convertToDate("02/11/2022"), "Superhero", true);
			movieList.add(itemOne);
			movieList.add(itemTwo);
			movieList.add(itemThree);
			movieList.add(itemFour);
			movieList.add(itemFive);

		}
	}

	public List<Movies> getMoviesListAdmin() {
		return movieList;
	}

	public List<Movies> getMoviesListCustomer() {
		ArrayList<Movies> filteredMovie = new ArrayList<Movies>();
		for (Movies movies : movieList) {
			if (movies.getDateOfLaunch().before(new Date())) {
				if (movies.getActive()) {
					filteredMovie.add(movies);
				}
			}
		}
		return filteredMovie;
	}

	public void modifyMovies(Movies movies) {
		for (int i = 0; i < movieList.size(); i++) {
			if (movieList.get(i).getId() == movies.getId()) {
				movieList.set(i, movies);
				return;
			}
		}
		return;
	}

	public Movies getMovies(Long moviesId) {
		for (Movies movies : movieList) {
			if (movies.getId() == moviesId) {
				return movies;
			}
		}
		return null;
	}

}
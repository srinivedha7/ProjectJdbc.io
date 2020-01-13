package com.cognizant.movie.dao;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;

import com.cognizant.movie.model.Favorites;

import com.cognizant.movie.model.Movies;

public class FavoritesDaoCollectionImpl implements FavoritesDao {

	private static HashMap<Long, Favorites> userFavorites;

	public FavoritesDaoCollectionImpl() {
		if (userFavorites == null) {
			userFavorites = new HashMap<>();

		}
	}

	public void addFavoriteMovies(long userId, long movieId) {
		MoviesDao moviesDao = new MoviesDaoCollectionImpl();
		Movies movies = moviesDao.getMovies(movieId);
		if (userFavorites.containsKey(userId)) {
			userFavorites.get(userId).getMovieList().add(movies);
		} else {
			Favorites favorite = new Favorites();
			ArrayList<Movies> movieList = new ArrayList<>();
			movieList.add(movies);
			favorite.setMovieList(movieList);
			userFavorites.put(userId, favorite);
		}
	}

	public Favorites getAllFavoriteMovies(long userId) throws FavoritesEmptyException {
		// List<Movies> movieList = userFavorites.get(userId).getMovieList();
		Favorites favorites = userFavorites.get(userId);
		int noOfFavorites = 0;
		if (favorites == null || favorites.getMovieList().isEmpty()) {
			throw new FavoritesEmptyException();
		}
		List<Movies> moviesList = favorites.getMovieList();
		noOfFavorites += moviesList.size();
		favorites.setNoOfFavorites(noOfFavorites);
		return favorites;
	}

	public void removeFavoriteMovies(long userId, long movieId) {
		List<Movies> movieList = userFavorites.get(userId).getMovieList();
		for (int i = 0; i < movieList.size(); i++) {
			if (movieList.get(i).getId() == movieId) {
				movieList.remove(i);
				return;
			}
		}
	}

}
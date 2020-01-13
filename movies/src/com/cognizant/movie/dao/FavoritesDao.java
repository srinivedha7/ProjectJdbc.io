package com.cognizant.movie.dao;

import com.cognizant.movie.model.Favorites;


public interface FavoritesDao {

	public void addFavoriteMovies(long userId, long movieId);

	public Favorites getAllFavoriteMovies(long userId) throws FavoritesEmptyException;

	public void removeFavoriteMovies(long userId, long movieId);
}

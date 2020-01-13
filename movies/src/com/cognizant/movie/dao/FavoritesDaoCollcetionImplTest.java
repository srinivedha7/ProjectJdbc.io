package com.cognizant.movie.dao;

import com.cognizant.movie.model.Favorites;
import com.cognizant.movie.model.Movies;

public class FavoritesDaoCollcetionImplTest {

	public static void testAddFavoriteMovies() throws FavoritesEmptyException {
		FavoritesDao favoritesDao = new FavoritesDaoCollectionImpl();
		favoritesDao.addFavoriteMovies(1, 2L);
		favoritesDao.addFavoriteMovies(1, 5L);
		favoritesDao.addFavoriteMovies(2, 2L);
		favoritesDao.addFavoriteMovies(2, 3L);
		favoritesDao.addFavoriteMovies(2, 5L);
		System.out.println("User Added Favorites List");
		// List<Movies> movieListCustomer = favoritesDao.getAllFavoriteMovies(2);
		Favorites favorites = favoritesDao.getAllFavoriteMovies(1);
		for (Movies movies : favorites.getMovieList()) {
			System.out.println(movies);
		}
		System.out.println("No of Favorites:" + favorites.getMovieList().size());
	}

	public static void testRemoveFavoriteMovies() {
		FavoritesDao favoritesDao = new FavoritesDaoCollectionImpl();
		System.out.println("Movie List for Customer after Removal");
		try {
			favoritesDao.removeFavoriteMovies(2, 2L);
			// favoritesDao.removeFavorites(2, 3L);
			// favoritesDao.removeFavorites(2, 5L);

			Favorites favorites = favoritesDao.getAllFavoriteMovies(2);

			for (Movies movies : favorites.getMovieList()) {
				System.out.println(movies);
			}
			System.out.println("No of Favorites:" + favorites.getMovieList().size());
		} catch (FavoritesEmptyException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] agrs) throws FavoritesEmptyException {
		testAddFavoriteMovies();
		testRemoveFavoriteMovies();
	}

}
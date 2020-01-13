package com.cognizant.movie.dao;

public class FavoritesEmptyException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FavoritesEmptyException() {
		super("Favorites is empty");
	}

}

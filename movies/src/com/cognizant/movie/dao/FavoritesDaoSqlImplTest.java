package com.cognizant.movie.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import com.cognizant.movie.model.Favorites;
import com.cognizant.movie.model.Movies;

public class FavoritesDaoSqlImplTest {
	public static void main(String[] agrs) throws FavoritesEmptyException, NumberFormatException, IOException {
		// testAddFavoriteMovies();
		// testRemoveFavoriteMovies();
		testGetAllFavoriteMovies();
	}

	private static void testRemoveFavoriteMovies() throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter user id");
		long userId = Long.parseLong(bf.readLine());
		System.out.println("Enter movie id");
		long movieId = Long.parseLong(bf.readLine());
		new FavoritesDaoSqlImpl().removeFavoriteMovies(userId, movieId);
	}

	private static void testAddFavoriteMovies() throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter user id");
		long userId = Long.parseLong(bf.readLine());
		System.out.println("Enter movie id");
		long movieId = Long.parseLong(bf.readLine());
		new FavoritesDaoSqlImpl().addFavoriteMovies(userId, movieId);
	}

	private static void testGetAllFavoriteMovies() throws FavoritesEmptyException {
		long userId = 1;
		Favorites favorites = new FavoritesDaoSqlImpl().getAllFavoriteMovies(userId);
		int noOfFavorites = favorites.getNoOfFavorites();
		List<Movies> movies = favorites.getMovieList();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("#,##,##,###");
		System.out.format("%15s%15s%15s%15s%15s%15s%20s", "ID", "TITLE", "GROSS", "ACTIVE", "DATE OF LAUNCH", "GENRE",
				"HAS TEASER");
		for (Movies movie : movies) {
			String active = movie.getActive() ? "Yes" : "No";
			String teaser = movie.getTeaser() ? "Yes" : "No";
			System.out.format("\n" + "%15s%20s%15s%10s%15s%20s%15s", movie.getId(), movie.getTitle(),
					df.format(movie.getGross()), active, sdf.format(movie.getDateOfLaunch()), movie.getGenre(), teaser);
		}
		System.out.println("\nNo of Favorites:" + noOfFavorites);
	}

}

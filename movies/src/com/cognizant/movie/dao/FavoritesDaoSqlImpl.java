package com.cognizant.movie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cognizant.movie.model.Favorites;
import com.cognizant.movie.model.Movies;

public class FavoritesDaoSqlImpl implements FavoritesDao {

	public static final String ADD_TO_FAVORITES = "INSERT INTO `movie`.`favorites` (`fav_us_id`, `fav_mov_id`) VALUES (?,?);";
	public static final String GET_ALL_FAVORITES = "select*from movie_list inner join favorites on fav_mov_id=mov_id where fav_us_id=?;";
	public static final String NO_OF_FAVORITES = "select count(fav_id) as no_of_favorites from movie.movie_list inner join movie.favorites where fav_mov_id=mov_id and fav_us_id=?";
	public static final String DELETE_FAVORITE = "delete from movie.favorites where fav_us_id=? and fav_mov_id=? limit 1";
	public void addFavoriteMovies(long userId, long movieId) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(ADD_TO_FAVORITES);
			statement.setLong(1, userId);
			statement.setLong(2, movieId);
			int noOfRows = statement.executeUpdate();
			System.out.println("No of rows affectes" + noOfRows);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public Favorites getAllFavoriteMovies(long userId) throws FavoritesEmptyException {
		Connection connection = ConnectionHandler.getConnection();
		ArrayList<Movies> moviesList = new ArrayList<Movies>();
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatementNoOfFavorites = null;
		ResultSet resultSet = null;
		ResultSet resultSetNoOfFavorites = null;
		Movies movies = null;
		Favorites favorites = new Favorites();
		try {
			preparedStatement = connection.prepareStatement(GET_ALL_FAVORITES);
			preparedStatement.setLong(1, userId);
			resultSet = preparedStatement.executeQuery();
			preparedStatementNoOfFavorites = connection.prepareStatement(NO_OF_FAVORITES);
			preparedStatementNoOfFavorites.setLong(1, userId);
			resultSetNoOfFavorites = preparedStatementNoOfFavorites.executeQuery();
			int noOfFavorites = 0;
			while (resultSet.next()) {
				movies = new Movies();
				movies.setId(resultSet.getLong("mov_id"));
				movies.setTitle(resultSet.getString("mov_title"));
				movies.setGross(resultSet.getLong("mov_gross"));
				movies.setActive(resultSet.getString("mov_active").equals("Yes"));
				movies.setDateOfLaunch(resultSet.getDate("mov_date_of_launch"));
				movies.setGenre(resultSet.getString("mov_genre"));
				movies.setTeaser(resultSet.getString("mov_teaser").equals("Yes"));
				moviesList.add(movies);
			}
			if (moviesList.size() == 0) {
				throw new FavoritesEmptyException();
			}
			favorites.setMovieList(moviesList);
			while (resultSetNoOfFavorites.next()) {
				noOfFavorites = resultSetNoOfFavorites.getInt("no_of_favorites");

			}
			favorites.setNoOfFavorites(noOfFavorites);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {

			}
		}
		return favorites;
	}

	public void removeFavoriteMovies(long userId, long movieId) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(DELETE_FAVORITE);
			statement.setLong(1, userId);
			statement.setLong(2, movieId);
			int noOfRows = statement.executeUpdate();
			System.out.println("No of rows affectes" + noOfRows);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {

				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}

			} catch (SQLException e) {

			}
		}
	}

}

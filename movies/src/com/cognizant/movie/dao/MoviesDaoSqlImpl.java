package com.cognizant.movie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.movie.model.Movies;
import com.cognizant.movie.util.DateUtil;

public class MoviesDaoSqlImpl implements MoviesDao {
	public static final String GET_ALL_MENU_ITEM_ADMIN = "SELECT * FROM movie.movie_list;\r\n";
	public static final String GET_ALL_MENU_ITEM_CUSTOMER = "SELECT*FROM movie_list where mov_date_of_launch > curdate() AND mov_active='Yes';";
	public static final String EDIT_MENU_ITEM = "UPDATE movie.movie_list SET mov_title=?, mov_gross=?, "
			+ "mov_active=?, mov_date_of_launch=?, mov_genre=?, mov_teaser=? WHERE (mov_id = ?);";
	public static final String GET_MOVIES = "select*from movie.movie_list where mov_id=?";

	public List<Movies> getMoviesListAdmin() {
		ArrayList<Movies> moviesList = new ArrayList<>();
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(GET_ALL_MENU_ITEM_ADMIN);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Movies movies = new Movies();

				movies.setId(resultSet.getLong("mov_id"));
				movies.setTitle(resultSet.getString("mov_title"));
				movies.setGross(resultSet.getLong("mov_gross"));
				movies.setActive(resultSet.getString("mov_active").equals("Yes"));
				movies.setDateOfLaunch(resultSet.getDate("mov_date_of_launch"));
				movies.setGenre(resultSet.getString("mov_genre"));
				movies.setTeaser(resultSet.getString("mov_teaser").equals("Yes"));
				moviesList.add(movies);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}

				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return moviesList;
	}

	public List<Movies> getMoviesListCustomer() {
		ArrayList<Movies> moviesListCustomer = new ArrayList<>();
		Connection connection = ConnectionHandler.getConnection();
		try {
			PreparedStatement preparedStatement = null;
			preparedStatement = connection.prepareStatement(GET_ALL_MENU_ITEM_CUSTOMER);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Movies movies = new Movies();
				movies.setId(resultSet.getLong("mov_id"));
				movies.setTitle(resultSet.getString("mov_title"));
				movies.setGross(resultSet.getLong("mov_gross"));
				movies.setActive(resultSet.getString("mov_active").equals("Yes"));
				movies.setDateOfLaunch(resultSet.getDate("mov_date_of_launch"));
				movies.setGenre(resultSet.getString("mov_genre"));
				movies.setTeaser(resultSet.getString("mov_teaser").equals("Yes"));
				moviesListCustomer.add(movies);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return moviesListCustomer;
	}

	public void modifyMovies(Movies movies) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(EDIT_MENU_ITEM);

			statement.setString(1, movies.getTitle());
			statement.setLong(2, movies.getGross());
			statement.setString(3, movies.getActive() ? "Yes" : "No");
			statement.setDate(4, new DateUtil().convertToSqlDate(movies.getDateOfLaunch()));
			statement.setString(5, movies.getGenre());
			statement.setString(6, movies.getTeaser() ? "Yes" : "No");
			statement.setLong(7, movies.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
	
	public Movies getMovies(Long movieId) {
		Movies movies = null;
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(GET_MOVIES);
			statement.setLong(1, movieId);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				movies = new Movies();
				movies.setId(resultSet.getLong("mov_id"));
				movies.setTitle(resultSet.getString("mov_title"));
				movies.setGross(resultSet.getLong("mov_gross"));
				movies.setActive(resultSet.getString("mov_active").equals("Yes"));
				movies.setDateOfLaunch(resultSet.getDate("mov_date_of_launch"));
				movies.setGenre(resultSet.getString("mov_genre"));
				movies.setTeaser(resultSet.getString("mov_teaser").equals("Yes"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return movies;
	}

}

package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImpl implements CartDao {
	public static final String ADD_TO_CART = "INSERT INTO `truyum`.`cart` (`ct_us_id`, `ct_me_id`) VALUES (?, ?);\r\n";

	public void addCartItem(long userId, long menuItemId) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(ADD_TO_CART);
			statement.setLong(1, userId);
			statement.setLong(2, menuItemId);
			int noOfRows = statement.executeUpdate();
			System.out.println("No of rows affectes" + noOfRows);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (statement != null) {
				statement.close();
			}
		} catch (SQLException e) {
		}
	}

	public static final String GET_ALL_CART_ITEM = "select*from truyum.menu_item inner join truyum.cart on ct_me_id=me_id where ct_us_id=?";
	public static final String GET_TOTAL = "select sum(me_price) as Total from truyum.menu_item inner join truyum.cart on ct_me_id= me_id";

	public Cart getAllCartItems(long userId) throws CartEmptyException {
		Connection connection = ConnectionHandler.getConnection();
		ArrayList<MenuItem> menuItemList = new ArrayList<MenuItem>();
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatementTotal = null;
		ResultSet resultSet = null;
		ResultSet resultSetTotal = null;
		MenuItem menuItem = null;
		Cart cart = new Cart();
		try {
			preparedStatement = connection.prepareStatement(GET_ALL_CART_ITEM);
			preparedStatement.setLong(1, userId);
			resultSet = preparedStatement.executeQuery();
			preparedStatementTotal = connection.prepareStatement(GET_TOTAL);
			resultSetTotal = preparedStatementTotal.executeQuery();
			double total = 0.0;
			while (resultSet.next()) {
				menuItem = new MenuItem();
				menuItem.setId(resultSet.getLong("me_id"));
				menuItem.setName(resultSet.getString("me_name"));
				menuItem.setPrice(resultSet.getFloat("me_price"));
				menuItem.setActive(resultSet.getString("me_active").equals("Yes"));
				menuItem.setDateOfLaunch(resultSet.getDate("me_date_of_launch"));
				menuItem.setCategory(resultSet.getString("me_category"));
				menuItem.setFreeDelivery(resultSet.getString("me_free_delivery").equals("Yes"));
				menuItemList.add(menuItem);
			}
			if (menuItemList.size() == 0) {
				throw new CartEmptyException();
			}
			cart.setMenuItemList(menuItemList);
			while (resultSetTotal.next()) {
				total = resultSetTotal.getDouble("Total");

			}
			cart.setTotal(total);
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
			} catch (SQLException e) {

			}
		}
		return cart;
	}

	public static final String DELETE_CART = "delete from truyum.cart where ct_us_id=? and  ct_me_id=? limit 1";

	public void removeCartItem(long userId, long menuItemId) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(DELETE_CART);
			statement.setLong(1, userId);
			statement.setLong(2, menuItemId);
			int noOfRows = statement.executeUpdate();
			System.out.println("No of rows affected" + noOfRows);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {

				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {

			}
		}
	}

}

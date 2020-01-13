package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoSqlImpl implements MenuItemDao {
	public static final String GET_ALL_MENU_ITEM_ADMIN = "select*from truyum.menu_item";

	public ArrayList<MenuItem> getMenuItemListAdmin() {
		ArrayList<MenuItem> menuItemList = new ArrayList<>();
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(GET_ALL_MENU_ITEM_ADMIN);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				MenuItem menuItem = new MenuItem();
				menuItem.setId(resultSet.getLong("me_id"));
				menuItem.setName(resultSet.getString("me_name"));
				menuItem.setPrice(resultSet.getFloat("me_price"));
				menuItem.setActive(resultSet.getString("me_active").equals("Yes"));
				menuItem.setDateOfLaunch(resultSet.getDate("me_date_of_launch"));
				menuItem.setCategory(resultSet.getString("me_category"));
				menuItem.setFreeDelivery(resultSet.getString("me_free_delivery").equals("Yes"));
				menuItemList.add(menuItem);
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
		return menuItemList;
	}

	public static final String GET_ALL_MENU_ITEM_CUSTOMER = "SELECT*FROM truyum.menu_item  "
			+ "where me_date_of_launch > curdate() and  me_active = 'yes';";

	public List<MenuItem> getMenuItemListCustomer() {
		ArrayList<MenuItem> menuItemListCustomer = new ArrayList<>();
		Connection connection = ConnectionHandler.getConnection();
		try {
			PreparedStatement preparedStatement = null;
			preparedStatement = connection.prepareStatement(GET_ALL_MENU_ITEM_CUSTOMER);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				MenuItem menuItem = new MenuItem();
				menuItem.setId(resultSet.getLong("me_id"));
				menuItem.setName(resultSet.getString("me_name"));
				menuItem.setPrice(resultSet.getFloat("me_price"));
				menuItem.setActive(resultSet.getString("me_active").equals("Yes"));
				menuItem.setDateOfLaunch(resultSet.getDate("me_date_of_launch"));
				menuItem.setCategory(resultSet.getString("me_category"));
				menuItem.setFreeDelivery(resultSet.getString("me_free_delivery").equals("Yes"));
				menuItemListCustomer.add(menuItem);
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
		return menuItemListCustomer;
	}

	public static final String EDIT_MENU_ITEM = "UPDATE `truyum`.`menu_item` SET me_id=?, me_name=?, me_price=?, me_active=?, me_date_of_launch=?, me_category=?, me_free_delivery=? WHERE (me_id = ?);";

	public void modifyMenuItem(MenuItem menuItem) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(EDIT_MENU_ITEM);
			statement.setLong(1, menuItem.getId());
			statement.setString(2, menuItem.getName());
			statement.setFloat(3, menuItem.getPrice());
			statement.setString(4, menuItem.getActive() ? "Yes" : "No");
			statement.setDate(5, new DateUtil().convertToSqlDate(menuItem.getDateOfLaunch()));
			statement.setString(6, menuItem.getCategory());
			statement.setString(7, menuItem.getFreeDelivery() ? "Yes" : "No");
			statement.setLong(8, menuItem.getId());
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

	public static final String GET_MENU_ITEM = "select*from truyum.menu_item where me_id=?";

	public MenuItem getMenuItem(Long menuItemId) {
		MenuItem menuItem = null;
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(GET_MENU_ITEM);
			statement.setLong(1, menuItemId);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				menuItem = new MenuItem();
				menuItem.setId(resultSet.getLong("me_id"));
				menuItem.setName(resultSet.getString("me_name"));
				menuItem.setPrice(resultSet.getFloat("me_price"));
				menuItem.setActive(resultSet.getString("me_active").equals("Yes"));
				menuItem.setDateOfLaunch(resultSet.getDate("me_date_of_launch"));
				menuItem.setCategory(resultSet.getString("me_category"));
				menuItem.setFreeDelivery(resultSet.getString("me_free_delivery").equals("Yes"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return menuItem;
	}
}

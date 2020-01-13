package com.cognizant.truyum.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImplTest {
	public static void main(String[] args) throws CartEmptyException, NumberFormatException, IOException {
		// testAddCartItem();
		// testRemoveCart();
		testGetAllCartItems();
	}

	public static void testAddCartItem() throws CartEmptyException, NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter user id");
		long userId = Long.parseLong(bf.readLine());
		System.out.println("Enter user menu item id");
		long menuItemId = Long.parseLong(bf.readLine());
		new CartDaoSqlImpl().addCartItem(userId, menuItemId);
	}

	public static void testRemoveCart() throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter user id");
		long userId = Long.parseLong(bf.readLine());
		System.out.println("Enter user menu item id");
		long menuItemId = Long.parseLong(bf.readLine());
		new CartDaoSqlImpl().removeCartItem(userId, menuItemId);
	}

	public static void testGetAllCartItems() throws NumberFormatException, IOException, CartEmptyException {
		long userId = 1;
		Cart cart = new CartDaoSqlImpl().getAllCartItems(userId);
		double total = cart.getTotal();
		List<MenuItem> menuItem = cart.getMenuItemList();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("#.00");
		System.out.format("%15s%15s%15s%15s%15s%15s%15s", "ID", "NAME", "PRICE", "ACTIVE", "DATE OF LAUNCH", "CATEGORY",
				"FREE-DELIVERY");
		for (MenuItem menuItems : menuItem) {
			String active = menuItems.getActive() ? "Yes" : "No";
			String freeDelivery = menuItems.getFreeDelivery() ? "Yes" : "No";
			System.out.format("\n" + "%15s%15s%15s%15s%15s%15s%15s", menuItems.getId(), menuItems.getName(),
					df.format(menuItems.getPrice()), active, sdf.format(menuItems.getDateOfLaunch()),
					menuItems.getCategory(), freeDelivery);
		}
		System.out.println("\nTotal:" + total);
	}

}

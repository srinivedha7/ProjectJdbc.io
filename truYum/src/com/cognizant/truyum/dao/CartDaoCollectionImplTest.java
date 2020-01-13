package com.cognizant.truyum.dao;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImplTest {

	public static void testAddCartItem() throws CartEmptyException {
		CartDao cartDao = new CartDaoCollectionImpl();
		cartDao.addCartItem(1, 2L);
		cartDao.addCartItem(1, 5L);
		cartDao.addCartItem(2, 2L);
		cartDao.addCartItem(2, 3L);
		cartDao.addCartItem(2, 5L);
		System.out.println("User Added Cart List for Checkout");
		Cart cart = cartDao.getAllCartItems(2);
		for (MenuItem menuItem : cart.getMenuItemList()) {
			System.out.println(menuItem);
		}
	}

	public static void testRemoveCartItem() {
		CartDao cartDao = new CartDaoCollectionImpl();
		System.out.println("Item List for Customer after Removal");
		try {
			cartDao.removeCartItem(2, 2L);
			// cartDao.removeCartItem(2, 3L);
			// cartDao.removeCartItem(2, 5L);

			Cart cart = cartDao.getAllCartItems(2);

			for (MenuItem menuItem : cart.getMenuItemList()) {
				System.out.println(menuItem);
			}
		} catch (CartEmptyException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void testGetAllCartItems() {

	}

	public static void main(String[] args) throws CartEmptyException {
		testAddCartItem();
		testRemoveCartItem();
	}

}
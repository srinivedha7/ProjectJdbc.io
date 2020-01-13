package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;

import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImplTest {

	public static void testGetMenuItemListAdmin() {
		System.out.println("Item List for Admin");
		List<MenuItem> menuItemList = new MenuItemDaoCollectionImpl().getMenuItemListAdmin();
		for (MenuItem menuItem : menuItemList) {
			System.out.println(menuItem);
		}
	}

	public static void testGetMenuItemListCustomer() {
		System.out.println("Item List for Customer");
		List<MenuItem> menuItemList = new MenuItemDaoCollectionImpl().getMenuItemListCustomer();
		for (MenuItem menuItem : menuItemList) {
			System.out.println(menuItem);
		}
	}

	public static void testModifyMenuItem() {
		MenuItem menuItem = new MenuItem(5L, "Briyani", 52.00f, true, new DateUtil().convertToDate("02/11/2022"),
				"Main Course", true);
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		menuItemDao.modifyMenuItem(menuItem);
		System.out.println("Modified Menu Item List");
		testGetMenuItemListAdmin();
		MenuItem modified_item = menuItemDao.getMenuItem(menuItem.getId());
		System.out.println("Modified Item detail\n" + modified_item);
	}

	public static void main(String[] args) {
		testGetMenuItemListAdmin();
		testGetMenuItemListCustomer();
		testModifyMenuItem();
	}

}
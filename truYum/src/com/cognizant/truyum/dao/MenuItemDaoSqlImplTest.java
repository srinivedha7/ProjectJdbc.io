package com.cognizant.truyum.dao;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoSqlImplTest {
	public static void main(String[] args) {
		testModifyMenuItem();
		testGetMenuItemListAdmin();
		testGetMenuItemListCustomer();
		testGetMenuItem();
	}

	public static void display(List<MenuItem> menuItemList) {
		DecimalFormat df = new DecimalFormat("##,###.00");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.format("\n%15s%15s%15s%15s%15s%15s%15s\n", "ID", "NAME", "PRICE", "	 DATE OF LAUNCH", "ACTIVE",
				"CATEGORY", "	FREE DELIVERY");
		for (MenuItem menu_item : menuItemList) {
			String freeDelivery = menu_item.getFreeDelivery() ? "Yes" : "No";
			String active = menu_item.getActive() ? "Yes" : "No";
			System.out.format("\n%15s%15s%15s%15s%15s%15s%15s\n", menu_item.getId(), menu_item.getName(),
					df.format(menu_item.getPrice()), sdf.format(menu_item.getDateOfLaunch()), active,
					menu_item.getCategory(), freeDelivery);
		}
	}

	public static void testGetMenuItemListAdmin() {
		System.out.println("ADMIN LIST");
		ArrayList<MenuItem> menuItemList = new MenuItemDaoSqlImpl().getMenuItemListAdmin();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("#.00");
		System.out.format("%15s%15s%15s%15s%15s%15s%15s", "ID", "NAME", "PRICE", "ACTIVE", "DATE OF LAUNCH", "CATEGORY",
				"FREE-DELIVERY");
		for (MenuItem menuItems : menuItemList) {
			String freeDelivery = menuItems.getFreeDelivery() ? "Yes" : "No";
			String active = menuItems.getActive() ? "Yes" : "No";
			System.out.format("\n" + "%15s%15s%15s%15s%15s%15s%15s", menuItems.getId(), menuItems.getName(),
					df.format(menuItems.getPrice()), active, sdf.format(menuItems.getDateOfLaunch()),
					menuItems.getCategory(), freeDelivery);
		}
	}

	public static void testGetMenuItemListCustomer() {
		System.out.println("CUSTOMER LIST");
		List<MenuItem> menuItemListCustomer = new MenuItemDaoSqlImpl().getMenuItemListCustomer();
		DecimalFormat df = new DecimalFormat("#.00");
		System.out.format("%15s%15s%15s%15s%15s", "ID", "NAME", "FREE-DELIVERY", "PRICE", "CATEGORY");
		for (MenuItem menuItems : menuItemListCustomer) {
			String freeDelivery = menuItems.getFreeDelivery() ? "Yes" : "No";
			System.out.format("\n" + "%15s%15s%15s%15s%15s", menuItems.getId(), menuItems.getName(), freeDelivery,
					df.format(menuItems.getPrice()), menuItems.getCategory());
		}
	}

	public static void testModifyMenuItem() {
		MenuItem menuItem = new MenuItem(1L, "AB", 126.50f, true, new DateUtil().convertToDate("15/03/2017"), "Dessert",
				true);
		new MenuItemDaoSqlImpl().modifyMenuItem(menuItem);
		System.out.println("Modified item" + menuItem);

	}

	public static void testGetMenuItem() {
		long menuItemId = 2;
		System.out.println("GET MENU ITEM");
		MenuItem menuItem = new MenuItemDaoSqlImpl().getMenuItem(menuItemId);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("#.00");
		System.out.format("%15s%15s%15s%15s%15s%15s%15s", "ID", "NAME", "PRICE", "ACTIVE", "DATE OF LAUNCH", "CATEGORY",
				"FREE-DELIVERY");
		String freeDelivery = menuItem.getFreeDelivery() ? "Yes" : "No";
		String active = menuItem.getActive() ? "Yes" : "No";
		System.out.format("\n" + "%15s%15s%15s%15s%15s%15s%15s", menuItem.getId(), menuItem.getName(),
				df.format(menuItem.getPrice()), active, sdf.format(menuItem.getDateOfLaunch()), menuItem.getCategory(),
				freeDelivery);
	}

}
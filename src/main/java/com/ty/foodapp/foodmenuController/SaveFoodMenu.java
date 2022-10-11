package com.ty.foodapp.foodmenuController;

import com.ty.foodapp.dao.FoodMenuDao;
import com.ty.foodapp.dto.FoodMenu;

public class SaveFoodMenu {

	public static void main(String[] args) {

		FoodMenu foodmenu = new FoodMenu();
		foodmenu.setName("Tandoori Roti");
		foodmenu.setCost(280);
		foodmenu.setDescription("Bread");
		
		FoodMenuDao dao = new FoodMenuDao();
		
		dao.saveFoodMenu(foodmenu);

	}

}

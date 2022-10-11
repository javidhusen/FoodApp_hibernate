package com.ty.foodapp.foodmenuController;

import java.util.List;

import com.ty.foodapp.dao.FoodMenuDao;
import com.ty.foodapp.dto.FoodMenu;

public class GetAllFoodMenuDetails {

	public static void main(String[] args) {

		FoodMenuDao dao = new FoodMenuDao();
		List<FoodMenu> foodMenu = dao.getAllFoodMenuDetails();
		System.out.println(foodMenu);
	}

}

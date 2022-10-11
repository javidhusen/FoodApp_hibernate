package com.ty.foodapp.foodmenuController;

import com.ty.foodapp.dao.FoodMenuDao;
import com.ty.foodapp.dto.FoodMenu;

public class GetFoodById {

	public static void main(String[] args) {
		FoodMenuDao dao=new FoodMenuDao();
		FoodMenu foodMenu= dao.getFoodById(1);
		System.out.println(foodMenu);
	}
}

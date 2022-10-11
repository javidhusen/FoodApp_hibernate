package com.ty.foodapp.foodOrderController;

import com.ty.foodapp.dao.FoodOrderDao;

public class GetOrderById {

	public static void main(String[] args) {
		FoodOrderDao dao = new FoodOrderDao();
		dao.getOrderById(2);
	}
}

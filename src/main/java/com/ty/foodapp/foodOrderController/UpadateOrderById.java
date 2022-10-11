package com.ty.foodapp.foodOrderController;

import com.ty.foodapp.dao.FoodOrderDao;

public class UpadateOrderById {

	public static void main(String[] args) {

		FoodOrderDao dao = new FoodOrderDao();
		dao.updateOrderBy(4);
	}

}

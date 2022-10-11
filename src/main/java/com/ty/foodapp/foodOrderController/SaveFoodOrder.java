package com.ty.foodapp.foodOrderController;

import java.util.ArrayList;
import java.util.List;

import com.ty.foodapp.dao.FoodMenuDao;
import com.ty.foodapp.dao.FoodOrderDao;
import com.ty.foodapp.dto.FoodMenu;
import com.ty.foodapp.dto.FoodOrder;
import com.ty.foodapp.dto.Item;

public class SaveFoodOrder {

	public static void main(String[] args) {

		FoodOrder foodOrder = new FoodOrder();
		FoodMenuDao foodMenuDao = new FoodMenuDao();

		FoodMenu foodMenu = foodMenuDao.getFoodById(1);

		Item item = new Item();
		item.setName(foodMenu.getName());
		item.setQuantity(3);
		item.setCost(foodMenu.getCost());
		item.setTotal(item.getQuantity() * item.getCost());
		item.setFoodOrder(foodOrder);

		FoodMenu foodMenu1 = foodMenuDao.getFoodById(3);
		Item item1 = new Item();
		item1.setName(foodMenu1.getName());
		item1.setQuantity(2);
		item1.setCost(foodMenu1.getCost());
		item1.setTotal(item1.getQuantity() * item1.getCost());
		item1.setFoodOrder(foodOrder);

		FoodMenu foodMenu2 = foodMenuDao.getFoodById(8);
		Item item2 = new Item();
		item2.setName(foodMenu2.getName());
		item2.setQuantity(2);
		item2.setCost(foodMenu2.getCost());
		item2.setTotal(item2.getQuantity() * item2.getCost());
		item2.setFoodOrder(foodOrder);

		List<Item> l = new ArrayList<Item>();
		l.add(item);
		l.add(item1);
		l.add(item2);

		foodOrder.setStatus("Order placed");

		int total = 0;
		for (Item items : l) {
			total += items.getTotal();

		}
		foodOrder.setTotal_cost(total);
		foodOrder.setItem(l);

		FoodOrderDao dao = new FoodOrderDao();
		dao.saveFoodOrder(foodOrder);
	}

}

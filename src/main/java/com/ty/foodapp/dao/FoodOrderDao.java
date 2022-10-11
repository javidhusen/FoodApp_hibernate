package com.ty.foodapp.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.foodapp.dto.FoodMenu;
import com.ty.foodapp.dto.FoodOrder;
import com.ty.foodapp.dto.Item;

public class FoodOrderDao {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = factory.createEntityManager();

	public FoodOrder saveFoodOrder(FoodOrder foodOrder) {
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(foodOrder);
		for(Item items:foodOrder.getItem()) {
		entityManager.persist(items);
		}
		entityTransaction.commit();
		
		return foodOrder;

	}

	public FoodOrder getOrderById(int id) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = factory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		FoodOrder foodOrder = entityManager.find(FoodOrder.class, id);
		System.out.println(foodOrder);
		entityTransaction.commit();
		return foodOrder;
	}

	public void updateOrderBy(int id) {
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Item item = new Item();
		List<Item> l = new ArrayList<Item>();
		FoodOrder order = new FoodOrder();
		order.setId(id);
		order.setStatus("Prepared");
		order.setTotal_cost(1500);
		order.setItem(l);

		entityTransaction.begin();
		entityManager.merge(order);
		entityTransaction.commit();
	}
}

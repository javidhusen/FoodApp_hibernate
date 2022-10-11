package com.ty.foodapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.foodapp.dto.FoodMenu;

public class FoodMenuDao {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = factory.createEntityManager();
	
	public FoodMenu saveFoodMenu(FoodMenu foodMenu) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = factory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(foodMenu);	
		entityTransaction.commit();
		
		return foodMenu;
	}

	public List<FoodMenu> getAllFoodMenuDetails() {
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Query query = entityManager.createQuery("SELECT f FROM FoodMenu f");
		List<FoodMenu> l = query.getResultList();
		return l;
	}
	
	public FoodMenu getFoodById(int id) {
		FoodMenu foodMenu = entityManager.find(FoodMenu.class, id);
		if (foodMenu != null) {
			return foodMenu;
		}
		return null;
	}
}

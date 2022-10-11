package com.ty.foodapp.dao;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.foodapp.dto.Customer;

public class CustomerDao {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = factory.createEntityManager();
	
	public Customer saveCustomer(Customer customer) {
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(customer);
		entityTransaction.commit();

		return customer;
	}
	
	public void getCustomerById(int id) {
		Customer customer = entityManager.find(Customer.class, id);
		System.out.println(customer);
	}
}

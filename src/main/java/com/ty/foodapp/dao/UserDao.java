package com.ty.foodapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.foodapp.dto.User;
import com.ty.foodapp.helper.AES;

public class UserDao {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = factory.createEntityManager();
	AES aes = new AES();

	public User saveUser(User user) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = factory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
		return user;
	}
	
	public User getUserByEmail(String email) {
	    
		String jpql="SELECT u FROM User u where email=?1";
		Query query=entityManager.createQuery(jpql);
		query.setParameter(1, email);
		User user=(User) query.getSingleResult();
		return user;
	}

	public void validateUserByEmailPassword(String email, String password) {
		User user=getUserByEmail(email);
		
		if (aes.decrypt(((User) user).getPassword()).equals(password)) {
			System.out.println("Validation successfull");
		}

		else {
			System.out.println("User Not Found");
		}
	}
	
	public User getUserById(int id) {
		User user=entityManager.find(User.class, id);
		return user;
	}
	
	public String updateUser(User user) {
		User user1=entityManager.find(User.class, user.getId());
		if(user1!=null) {
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.merge(user);
			entityTransaction.commit();
			return "Updated successfully....!";
		}else {
			return "User with id: "+user.getId()+" Not Found";
		}
	}
	
	public User validateUserByPhone(long phone, String password) {
		String jpql="SELECT u FROM User u where phone=?1";
		Query query=entityManager.createQuery(jpql);
		query.setParameter(1, phone);
		User user=(User) query.getSingleResult();
		if(user.getPhone()==phone) {
			if(aes.decrypt(user.getPassword()).equals(password)){
				return user;
			}
			return user;
		}else {
			return null;
		}
	}
	
	public String deleteUserById(int id) {
		User user=entityManager.find(User.class, id);
			if(user!=null)	{
				EntityTransaction entityTransaction=entityManager.getTransaction();
				entityTransaction.begin();
				entityManager.remove(user);
				entityTransaction.commit();
			return "user deleted successfully...";
		}else {
			return "Id Not Found";
		}
	}
}

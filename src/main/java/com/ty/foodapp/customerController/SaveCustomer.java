package com.ty.foodapp.customerController;

import com.ty.foodapp.dao.CustomerDao;
import com.ty.foodapp.dao.FoodOrderDao;
import com.ty.foodapp.dto.Customer;
import com.ty.foodapp.dto.FoodOrder;

public class SaveCustomer {

	public static void main(String[] args) {

		FoodOrderDao foodOrderDao=new FoodOrderDao();
		FoodOrder foodOrder=foodOrderDao.getOrderById(4);
		Customer customer=new Customer();
		customer.setName("Prakash");
		customer.setEmail("prakash@gmail.com");
		customer.setPhone(8742587412l);
		customer.setFoodorder(foodOrder);
		
		CustomerDao dao = new CustomerDao();
		dao.saveCustomer(customer);
	}

}

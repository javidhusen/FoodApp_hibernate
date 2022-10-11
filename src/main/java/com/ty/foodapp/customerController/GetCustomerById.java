package com.ty.foodapp.customerController;

import com.ty.foodapp.dao.CustomerDao;

public class GetCustomerById {

	public static void main(String[] args) {

		CustomerDao dao = new CustomerDao();
		dao.getCustomerById(5);
	}

}

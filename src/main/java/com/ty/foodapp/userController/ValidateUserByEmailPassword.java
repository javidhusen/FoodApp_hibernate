package com.ty.foodapp.userController;

import com.ty.foodapp.dao.UserDao;

public class ValidateUserByEmailPassword {

	public static void main(String[] args) {

		UserDao dao = new UserDao();
		dao.validateUserByEmailPassword("viru123@gmail", "viru@123");
	}

}

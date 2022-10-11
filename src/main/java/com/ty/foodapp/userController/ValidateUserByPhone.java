package com.ty.foodapp.userController;

import com.ty.foodapp.dao.UserDao;
import com.ty.foodapp.dto.User;

public class ValidateUserByPhone {

	public static void main(String[] args) {
		UserDao dao=new UserDao();
		User user=dao.validateUserByPhone(7407542435l, "taj@123");
		System.out.println(user);
	}
}

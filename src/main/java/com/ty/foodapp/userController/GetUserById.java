package com.ty.foodapp.userController;

import com.ty.foodapp.dao.UserDao;
import com.ty.foodapp.dto.User;

public class GetUserById {

	public static void main(String[] args) {
		UserDao userDao=new UserDao();
		User user=userDao.getUserById(3);
		
		System.out.println(user);
	}
}

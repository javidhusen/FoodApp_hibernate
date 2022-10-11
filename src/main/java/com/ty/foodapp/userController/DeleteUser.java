package com.ty.foodapp.userController;

import com.ty.foodapp.dao.UserDao;

public class DeleteUser {

	public static void main(String[] args) {
		UserDao dao=new UserDao();
		String msg=dao.deleteUserById(4);
		System.out.println(msg);
	}
}

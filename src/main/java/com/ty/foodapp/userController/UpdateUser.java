package com.ty.foodapp.userController;

import com.ty.foodapp.dao.UserDao;
import com.ty.foodapp.dto.User;
import com.ty.foodapp.helper.AES;

public class UpdateUser {

	public static void main(String[] args) {
		User user=new User();
		AES aes=new AES();
		user.setId(3);
		user.setName("Taj");
		user.setEmail("taj123@gmail");
		user.setPassword(aes.encrypt("taj@123"));
		user.setRole("Admin");
		user.setPhone(7407542435l);
		
		UserDao userDao=new UserDao();
		userDao.updateUser(user);
	}
}

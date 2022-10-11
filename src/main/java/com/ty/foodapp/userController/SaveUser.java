package com.ty.foodapp.userController;

import com.ty.foodapp.dao.UserDao;
import com.ty.foodapp.dto.User;
import com.ty.foodapp.helper.AES;

public class SaveUser {

	public static void main(String[] args) {

		User user = new User();
		AES aes = new AES();

		user.setName("Dinga");
		user.setPhone(6987542435l);
		user.setEmail("dinga123@gmail");
		user.setPassword(aes.encrypt("dinga@123"));
		user.setRole("manager");
		
		UserDao dao = new UserDao();
		dao.saveUser(user);
	}

}

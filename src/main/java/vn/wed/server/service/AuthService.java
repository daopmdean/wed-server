package vn.wed.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import vn.wed.server.common.Util;
import vn.wed.server.entity.User;

@Service
public class AuthService {

	@Autowired
	private AuthRepository repo;

	public User login(String email, String password) {
		User user = repo.getUserWithEmail(email);
		
		if (user == null) {
			return null;
		}
		
		String hassedPassword = Util.hassing(password, user.getPasswordSalt());
		
		if (user.getPassword().equals(hassedPassword)) {
			return user;
		}
		
		return null;
	}

	public boolean register(User userInfo) {
		User userInDB = repo.getUserWithEmail(userInfo.getEmail()); 
		boolean userExisted = false;
		
		if (userInDB != null) {
			userExisted = true;
		}
		
		if (userExisted) {
			return false;
		}
		
		userInfo.setPasswordSalt("abc");
		String hassedPassword = Util.hassing(userInfo.getPassword(), userInfo.getPasswordSalt());
		userInfo.setPassword(hassedPassword);
		
		return repo.createUser(userInfo);
	}
}

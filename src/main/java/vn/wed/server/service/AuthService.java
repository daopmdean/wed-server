package vn.wed.server.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import vn.wed.server.entity.User;
import vn.wed.server.util.JwtUtil;
import vn.wed.server.util.Util;

@Service
public class AuthService {

	@Autowired
	private AuthRepository repo;
	
	public User login(String email, String password) throws Exception {
		User user = repo.getUserByEmail(email);
		
		if (user == null) {
			throw new Exception("Invalid email or password");
		}
		
		String hassedPassword = Util.hash(password, user.getPasswordSalt());
		boolean isPasswordValid = user.getPassword().equals(hassedPassword); 
		
		if (!isPasswordValid) {
			throw new Exception("Invalid email or password");
		}
		
		return user;
	}
	
	public String genToken(String userEmail) {
		Map<String, Object> claims = new HashMap<String, Object>();
		
		claims.put("key1", "value1");
		claims.put("key2", "value2");
		claims.put("key3", "value3");
		
		return JwtUtil.genToken(claims, userEmail, 60);
	}
	
	public Map<String, Object> validate(String token) throws Exception {
		return JwtUtil.validate(token);
	}

	public boolean register(User userInfo) {
		User userInDB = repo.getUserByEmail(userInfo.getEmail()); 
		boolean userExisted = false;
		
		if (userInDB != null) {
			userExisted = true;
		}
		
		if (userExisted) {
			return false;
		}
		
		userInfo.setPasswordSalt(Util.createPasswordSalt(10));
		String hassedPassword = Util.hash(userInfo.getPassword(), userInfo.getPasswordSalt());
		userInfo.setPassword(hassedPassword);
		
		return repo.createUser(userInfo);
	}
}

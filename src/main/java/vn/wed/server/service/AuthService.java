package vn.wed.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.wed.server.entity.User;

@Service
public class AuthService {
	
	@Autowired
	private AuthRepository repo;
	
	public String login(String email, String password) throws Exception {
		User foundUser = repo.getUserByEmail(email);
		if (foundUser == null) {
			// User not found
			throw new Exception("Invalid Email or Password.");
		}
		
		String hashedPassword = hashPassword(password);
		
		if (!hashedPassword.equals(foundUser.getPassword())) {
			// Wrong password
			throw new Exception("Invalid Email or Password.");
		}
		
		return genAuthToken(foundUser);
	}
	
	private String genAuthToken(User user) {
		// use JWT to generate token
		return user.getEmail();
	}
	
	public boolean register(String email, String password, String firstName, String lastName) {
		User foundUser = repo.getUserByEmail(email);

		if (foundUser != null) {
			return false;
		}
		
		String hashedPassword = hashPassword(password);
		
		User user = new User(
				email,
				hashedPassword,
				firstName,
				lastName
		);
		
		repo.createUser(user);
		return true;
	}
	
	private String hashPassword(String password) {
		// TODO: implement hashing
		return "hashed-" + password;
	}
}

package vn.wed.server.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import vn.wed.server.entity.User;

@Component
public class AuthRepositoryImpl implements AuthRepository {
	private List<User> users;
	
	public AuthRepositoryImpl() {
		users = new ArrayList<User>();
		users.add(new User("daopm", "daopm@gmail.com", "password"));
		users.add(new User("dean", "dean@gmail.com", "password"));
		users.add(new User("admin", "admin@gmail.com", "admin"));
	}
	
	@Override
	public User login(String username, String password) {
		boolean validUsername;
		for (User user : users) {
			validUsername = user.getUsername().equalsIgnoreCase(username); 
			if (validUsername) {
				if (user.getPassword().equals(password)) {
					return user;
				}
			}
		}
		return null;
	}

	@Override
	public boolean register(User user) {
		return users.add(user);
	}

}

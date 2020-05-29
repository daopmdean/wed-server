package vn.wed.server.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import vn.wed.server.entity.User;
import vn.wed.server.service.AuthRepository;

@Component
public class AuthRepositoryImpl implements AuthRepository {
	private List<User> users;
	
	public AuthRepositoryImpl() {
		users = new ArrayList<User>();
		
		User user1 = new User("daopm@gmail.com", "passwordabc");
		user1.setPasswordSalt("abc");
		User user2 = new User("alex@gmail.com", "mypasserf");
		user2.setPasswordSalt("erf");
		User user3 = new User("admin@gmail.com", "adminwed");
		user3.setPasswordSalt("wed");
		
		users.add(user1);
		users.add(user2);
		users.add(user3);
	}

	@Override
	public User getUserWithEmail(String email) {
		for (User user : users) {
			if (user.getEmail().equalsIgnoreCase(email)) {
				return user;
			}
		}
		return null;
	}

	@Override
	public boolean createUser(User userInfo) {
		for (User user : users) {
			if (user.getEmail().equalsIgnoreCase(userInfo.getEmail())) {
				return false;
			}
		}
		
		return users.add(userInfo);
	}

}

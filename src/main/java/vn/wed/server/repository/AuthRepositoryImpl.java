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
		
		feedData();
	}

	@Override
	public User getUserByEmail(String email) {
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
		userInfo.setId(generateUserId());
		
		return users.add(userInfo);
	}
	
	private int generateUserId() {
		return users.size() + 1;
	}

	private void feedData() {
		users.add(DataFeeding.daopm());
		users.add(DataFeeding.alex());
	}
	
}

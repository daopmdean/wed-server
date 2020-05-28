package vn.wed.server.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import vn.wed.server.entity.User;
import vn.wed.server.service.AuthRepository;

@Component
public class AuthRepositoryImpl implements AuthRepository {
	private List<User> users = new ArrayList<User>();

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
	public boolean createUser(User userToCreate) {
		boolean foundExistUser = false;
		for (User user : users) {
			if (user.getEmail().equalsIgnoreCase(userToCreate.getEmail())) {
				foundExistUser = true;
				break;
			}
		}
		
		if (foundExistUser) {
			return false;
		}
		
		users.add(userToCreate);
		return true;
	}
}

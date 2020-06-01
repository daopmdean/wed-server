package vn.wed.server.service;

import vn.wed.server.entity.User;

public interface AuthRepository {
	public User getUserByEmail(String email);
	public boolean createUser(User user);
}

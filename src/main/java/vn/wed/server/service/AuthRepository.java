package vn.wed.server.service;

import vn.wed.server.entity.User;

public interface AuthRepository {
	public User getUserWithEmail(String email);
	public boolean createUser(User user);
}

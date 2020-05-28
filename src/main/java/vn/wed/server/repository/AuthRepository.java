package vn.wed.server.repository;

import vn.wed.server.entity.User;

public interface AuthRepository {
	public User login(String username, String password);
	public boolean register(User user);
}

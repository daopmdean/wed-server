package vn.wed.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import vn.wed.server.entity.User;
import vn.wed.server.repository.AuthRepository;

@Service
public class AuthService {
	
	@Autowired
	private AuthRepository repo;
	
	public User login(String username, String password) {
		return repo.login(username, password);
	}
	
	public boolean register(User user) {
		return repo.register(user);
	}
}

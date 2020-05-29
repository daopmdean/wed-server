package vn.wed.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vn.wed.server.entity.User;
import vn.wed.server.service.AuthService;

@RestController
public class AuthController {

	@Autowired
	private AuthService service;

	@PostMapping("/login")
	public User login(@RequestBody User loginInfo) {
		return service.login(loginInfo.getEmail(), loginInfo.getPassword());
	}

	@PostMapping("/register")
	public boolean register(@RequestBody User userInfo) {
		return service.register(userInfo);
	}
}

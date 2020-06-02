package vn.wed.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import vn.wed.server.entity.User;
import vn.wed.server.service.AuthService;
import vn.wed.server.util.JwtUtil;

@RestController
public class AuthController {

	@Autowired
	private AuthService service;
	
	@Autowired
	private AuthenticationManager authenticationManager; 

	@PostMapping("/login")
	public LoginResponse login(@RequestBody User loginInfo) {
		try {
			User user = service.login(loginInfo.getEmail(), loginInfo.getPassword());
			
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword())
			);

			String token = service.genToken(user.getEmail());
			return LoginResponse.success(token);
		}
		catch (Exception e) {
			return LoginResponse.error(e.getMessage());
		}
	}

	@PostMapping("/validate")
	public Object validate(@RequestBody String token) throws Exception {
		return JwtUtil.validate(token);
	}

	@PostMapping("/register")
	public boolean register(@RequestBody User userInfo) {
		return service.register(userInfo);
	}
}

class LoginResponse {
	private String token;
	private Error error;

	LoginResponse() {
	}
	
	static LoginResponse success(String token) {
		LoginResponse response = new LoginResponse();
		response.setToken(token);
		return response;
	}
	
	static LoginResponse error(String errorMessage) {
		LoginResponse response = new LoginResponse();
		response.setError(errorMessage);
		return response;
	}
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Error getError() {
		return error;
	}

	public void setError(String error) {
		this.error = new Error();
		this.error.setMessage(error);
	}

	class Error {
		private String message;

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
	}
}

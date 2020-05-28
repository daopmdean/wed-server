package vn.wed.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import vn.wed.server.service.AuthService;

@RestController
public class AuthController {

	@Autowired
	private AuthService service;

	@PostMapping("/login")
	public Object login(@RequestBody LoginDto info) {
		LoginResponse response = new LoginResponse();
		try {
			String authToken = service.login(info.getEmail(), info.getPassword());
			response.authToken = authToken;
		} catch (Exception e) {
			response.errorMessage = e.getMessage();
		}
		return response;
	}

	@PostMapping("/register")
	public boolean register(@RequestBody RegisterDto info) {
		return service.register(
				info.getEmail(),
				info.getPassword(),
				info.getFirstName(),
				info.getLastName()
		);
	}
}

class LoginResponse {
	public String authToken;
	public String errorMessage;
}

class LoginDto {
	private String email;
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

class RegisterDto {
	private String email;
	private String password;
	private String firstName;
	private String lastName;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
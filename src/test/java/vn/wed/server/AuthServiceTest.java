package vn.wed.server;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import vn.wed.server.entity.User;
import vn.wed.server.service.AuthService;

@SpringBootTest
public class AuthServiceTest {

	@Autowired
	private AuthService service;
	

	@Test
	void loginByUnexistUser() {
		Exception exception = assertThrows(Exception.class, () -> {
			service.login("daopm999@gmail.com", "password");
		});

		String expected = "Invalid email or password";
		String actual = exception.getMessage();

		assertThat(expected).isEqualTo(actual);
	}

	@Test
	void loginByWrongPassword() {
		Exception exception = assertThrows(Exception.class, () -> {
			service.login("daopm@gmail.com", "notThisPassword");
		});

		String expected = "Invalid email or password";
		String actual = exception.getMessage();

		assertThat(expected).isEqualTo(actual);
	}

	@Test
	void canLogin() throws Exception {
		String email = "daopm@gmail.com";
		User user = service.login(email, "password");

		assertThat(user.getEmail()).isEqualToIgnoringCase(email);
	}
	
	@Test
	void canRegisterUserFromService() {
		User newUser = new User("holy@gmail.com", "YouDoNotLogin");

		assertTrue(service.register(newUser));
	}

	@Test
	void canNotRegisterExistedUserFromService() {
		User newUser = new User("daopm@gmail.com", "YouDoNotLogin");

		assertFalse(service.register(newUser));
	}
}

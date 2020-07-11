package vn.wed.server;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import vn.wed.server.entity.User;
import vn.wed.server.service.AuthRepository;

@SpringBootTest
public class AuthRepoTest {

	@Autowired
	private AuthRepository repo;
	
	@Test
	void canRegisterUserFromRepo() {
		User user = new User("hoho@gmail.com", "passabc", "Hoho", "Max");
		user.setPasswordSalt("abc");
		
		assertThat(repo.createUser(user)).isTrue();
	}
	
	@Test
	void createDuplicatedEmailUser() {
		User user = new User("alex@gmail.com", "passdA333BeE%@", "Alex", "Max");
		user.setPasswordSalt("dA333BeE%@");
		
		assertThat(repo.createUser(user)).isFalse();
	}
	
	@Test
	void canFindUserByEmail() {
		User user = new User("toby@gmail.com", "passaccB3%55c#", "Toby", "Max");
		user.setPasswordSalt("accB3%55c#");
		repo.createUser(user);
		
		User userFromRepo = repo.getUserByEmail("toby@gmail.com");
		
		assertThat(userFromRepo.getEmail()).isEqualTo("toby@gmail.com");
		assertThat(userFromRepo.getPassword()).isEqualTo("passaccB3%55c#");
		assertThat(userFromRepo.getPasswordSalt()).isEqualTo("accB3%55c#");
	}
	
	@Test
	void findNoneExistUserInDB() {
		User user = repo.getUserByEmail("notExist@gmail.com");
		
		assertThat(user).isNull();
	}
}
